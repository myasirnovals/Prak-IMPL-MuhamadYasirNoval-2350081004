<?php
session_start();

if (!isset($_SESSION['id'])) {
    echo "Anda harus login terlebih dahulu.";
    exit;
}

$idPengirim  = $_SESSION['id'];
$idPenerima  = isset($_POST['Penerima']) ? $_POST['Penerima'] : '';
$judul       = isset($_POST['judul']) ? $_POST['judul'] : '';
$TextPesan   = isset($_POST['TextPesan']) ? $_POST['TextPesan'] : '';
$date        = date('Y-m-d H:i:s');

if ($idPenerima === '' || $judul === '' || $TextPesan === '') {
    echo "Data tidak lengkap, pesan gagal dikirim.";
    exit;
}

$host   = "localhost";
$user   = "root";
$pass   = "";
$dbname = "dbImpal";

$conn = mysqli_connect($host, $user, $pass, $dbname);

if (!$conn) {
    die("Koneksi gagal: " . mysqli_connect_error());
}

$idPengirim = mysqli_real_escape_string($conn, $idPengirim);
$idPenerima = mysqli_real_escape_string($conn, $idPenerima);
$judul      = mysqli_real_escape_string($conn, $judul);
$TextPesan  = mysqli_real_escape_string($conn, $TextPesan);
$date       = mysqli_real_escape_string($conn, $date);

$sql = "
    INSERT INTO pesan (idPesan, idPenerima, idPengirim, Judul, TextPesan, WktPesan)
    VALUES (NULL, '$idPenerima', '$idPengirim', '$judul', '$TextPesan', '$date')
";

$result = mysqli_query($conn, $sql);

if ($result) {
    echo "Pesan berhasil ditambahkan (pesan telah terkirim).";
} else {
    echo "Pesan gagal ditambahkan: " . mysqli_error($conn);
}

mysqli_close($conn);
?>
