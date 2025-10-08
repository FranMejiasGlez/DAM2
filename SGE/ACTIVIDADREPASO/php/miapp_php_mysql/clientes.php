<?php include 'db.php'; ?>

<h2>Clientes</h2>
<table border="1" cellpadding="5">
  <tr><th>ID</th><th>Nombre</th><th>Email</th><th>Teléfono</th></tr>
  <?php
  $result = $conn->query("SELECT * FROM clientes");
  while ($row = $result->fetch_assoc()) {
      echo "<tr>
              <td>{$row['ID_CLIENTE']}</td>
              <td>{$row['NOMBRE']}</td>
              <td>{$row['EMAIL']}</td>
              <td>{$row['TELEFONO']}</td>
            </tr>";
  }
  ?>
</table>
