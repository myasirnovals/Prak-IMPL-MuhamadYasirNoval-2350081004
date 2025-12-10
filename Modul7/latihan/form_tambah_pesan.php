<!doctype html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Tambah Pesan</title>
</head>
<body>

<h2>Tambah Pesan</h2>

<form action="simpan_pesan.php" method="post">
    <label for="penerima">ID Penerima:</label><br>
    <input type="text" id="penerima" name="Penerima" required><br><br>

    <label for="judul">Judul:</label><br>
    <input type="text" id="judul" name="judul" required><br><br>

    <label for="textPesan">Isi Pesan:</label><br>
    <textarea id="textPesan" name="TextPesan" rows="5" cols="40" required></textarea><br><br>

    <input type="submit" name="submit" value="Simpan">
</form>

</body>
</html>
