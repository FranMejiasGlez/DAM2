<?php include 'db.php'; ?>

<h2>Productos</h2>
<table border="1" cellpadding="5">
  <tr><th>ID</th><th>Nombre</th><th>Precio</th></tr>
  <?php
  $result = $conn->query("SELECT * FROM PRODUCTOS");
  while ($row = $result->fetch_assoc()) {
      echo "<tr>
              <td>{$row['ID_PRODUCTO']}</td>
              <td>{$row['NOMBRE']}</td>
              <td>{$row['PRECIO']}</td>
            </tr>";
  }
  ?>
</table>
