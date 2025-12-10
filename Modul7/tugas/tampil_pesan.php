<?php
session_start();

if (!isset($_SESSION['id'])) {
    echo "Anda harus login terlebih dahulu.";
    exit;
}

$idPenerima = $_SESSION['id'];

$host   = "localhost";
$user   = "root";
$pass   = "";
$dbname = "dbImpal";

$conn = mysqli_connect($host, $user, $pass, $dbname);

if (!$conn) {
    die("Koneksi gagal: " . mysqli_connect_error());
}

function getPesanByPenerima($conn, $idPenerima) {
    $idPenerima = mysqli_real_escape_string($conn, $idPenerima);

    $sql = "
        SELECT idPesan, idPengirim, Judul, TextPesan, WktPesan
        FROM pesan
        WHERE idPenerima = '$idPenerima'
        ORDER BY WktPesan DESC
    ";

    $result = mysqli_query($conn, $sql);

    $data = [];
    if ($result && mysqli_num_rows($result) > 0) {
        while ($row = mysqli_fetch_assoc($result)) {
            $data[] = $row;
        }
    }
    return $data;
}

$daftarPesan = getPesanByPenerima($conn, $idPenerima);
?>
<!doctype html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <title>Daftar Pesan Masuk</title>
</head>
<body>

<h2>Daftar Pesan Masuk</h2>

<?php if (empty($daftarPesan)) : ?>

    <p>Tidak ada pesan.</p>

<?php else : ?>

    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>ID Pesan</th>
            <th>Judul</th>
            <th>Pengirim</th>
            <th>Waktu</th>
            <th>Aksi</th>
        </tr>

        <?php foreach ($daftarPesan as $pesan) : ?>
            <tr>
                <td><?php echo htmlspecialchars($pesan['idPesan']); ?></td>
                <td><?php echo htmlspecialchars($pesan['Judul']); ?></td>
                <td><?php echo htmlspecialchars($pesan['idPengirim']); ?></td>
                <td><?php echo htmlspecialchars($pesan['WktPesan']); ?></td>
                <td>
                    <a href="hapusPesan.php?idPesan=<?php echo urlencode($pesan['idPesan']); ?>"
                       onclick="return confirm('Yakin ingin menghapus pesan ini?');">
                        Hapus
                    </a>
                </td>
            </tr>
        <?php endforeach; ?>

    </table>

<?php endif; ?>

</body>
</html>

<?php
mysqli_close($conn);
?>
