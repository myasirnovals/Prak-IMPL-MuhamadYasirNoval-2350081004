<?php
session_start();

if (!isset($_SESSION['id'])) {
    echo "Anda harus login terlebih dahulu.";
    exit;
}

$idUser  = $_SESSION['id'];
$idPesan = isset($_GET['idPesan']) ? $_GET['idPesan'] : '';

if ($idPesan === '') {
    echo "ID Pesan tidak ditemukan.";
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

function cekPemilikPesan($conn, $idPesan, $idUser) {
    $idPesan = mysqli_real_escape_string($conn, $idPesan);
    $idUser  = mysqli_real_escape_string($conn, $idUser);

    $sql = "
        SELECT idPesan
        FROM pesan
        WHERE idPesan = '$idPesan'
          AND idPenerima = '$idUser'
        LIMIT 1
    ";

    $result = mysqli_query($conn, $sql);

    if ($result && mysqli_num_rows($result) == 1) {
        return true;
    } else {
        return false;
    }
}

function hapus_datapesan($conn, $idPesan) {
    $idPesan = mysqli_real_escape_string($conn, $idPesan);

    $sql = "DELETE FROM pesan WHERE idPesan = '$idPesan'";
    $result = mysqli_query($conn, $sql);

    return $result ? true : false;
}

if (!cekPemilikPesan($conn, $idPesan, $idUser)) {
    echo "Anda tidak berhak menghapus pesan ini.";
    mysqli_close($conn);
    exit;
}

$hasil = hapus_datapesan($conn, $idPesan);

if ($hasil) {
    echo "pesan berhasil dihapus";
} else {
    echo "pesan gagal dihapus";
}

mysqli_close($conn);
?>
