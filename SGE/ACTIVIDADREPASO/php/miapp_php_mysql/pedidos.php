<?php include 'db.php'; ?>

<h2>Pedidos</h2>
<table border="1" cellpadding="5">
  <tr>
    <th>ID</th>
    <th>Cliente</th>
    <th>Producto</th>
    <th>Cantidad</th>
    <th>Precio Unitario</th>
    <th>Total</th>
    <th>Fecha</th>
  </tr>
  <?php
  $sql = "SELECT p.ID_PEDIDO, c.NOMBRE AS cliente, pr.NOMBRE AS producto, i.CANTIDAD, pr.PRECIO, (i.CANTIDAD * pr.PRECIO) AS total, p.FECHA
          FROM PEDIDOS p
          JOIN CLIENTES c ON p.ID_CLIENTE = c.ID_CLIENTE
          JOIN INCLUYEN i ON p.ID_PEDIDO = i.ID_PEDIDO
          JOIN PRODUCTOS pr ON i.ID_PRODUCTO = pr.ID_PRODUCTO
          ORDER BY p.ID_PEDIDO, pr.NOMBRE";
  $result = $conn->query($sql);

  $current_pedido = null;
  $total_unidades = 0;
  $total_pedido = 0;

  while ($row = $result->fetch_assoc()) {
    if ($current_pedido !== null && $current_pedido != $row['ID_PEDIDO']) {
      // Mostrar totales del pedido anterior
      echo "<tr style='font-weight:bold; background:#eee;'>
              <td colspan='3'>Totales del pedido</td>
              <td>{$total_unidades}</td>
              <td></td>
              <td>{$total_pedido}</td>
              <td></td>
            </tr>";
      // Reiniciar totales
      $total_unidades = 0;
      $total_pedido = 0;
    }

    $current_pedido = $row['ID_PEDIDO'];
    $total_unidades += $row['CANTIDAD'];
    $total_pedido += $row['total'];

    echo "<tr>
            <td>{$row['ID_PEDIDO']}</td>
            <td>{$row['cliente']}</td>
            <td>{$row['producto']}</td>
            <td>{$row['CANTIDAD']}</td>
            <td>{$row['PRECIO']}</td>
            <td>{$row['total']}</td>
            <td>{$row['FECHA']}</td>
          </tr>";
  }

  // Mostrar totales del último pedido
  if ($current_pedido !== null) {
    echo "<tr style='font-weight:bold; background:#eee;'>
            <td colspan='3'>Totales del pedido</td>
            <td>{$total_unidades}</td>
            <td></td>
            <td>{$total_pedido}</td>
            <td></td>
          </tr>";
  }
  ?>
</table>