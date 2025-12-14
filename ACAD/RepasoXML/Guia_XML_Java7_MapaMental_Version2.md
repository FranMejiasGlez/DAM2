# Guía Técnica: Mapa Mental para trabajar XML en Java 7

---

## 1. Creación de XML y Manejo de Documentos XML en Java

### a) Crear un documento XML desde cero (DOM)
- **Instanciar un parser DOM:**
    ```java
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = dbf.newDocumentBuilder();
    ```
- **Crear el documento vacío:**
    ```java
    Document documento = docBuilder.newDocument();
    ```
- **Crear y anexar nodo raíz:**
    ```java
    Element raiz = documento.createElement("nombreRaiz");
    documento.appendChild(raiz);
    ```
- **Agregar nodos hijos usando helpers:**
    - *Elemento vacío:*
      ```java
      Element hijo = creaElementoVacio(documento, "nombreNodo", raiz);
      ```
    - *Elemento con contenido:*
      ```java
      Element hijoLleno = creaElementoLleno(documento, "nombreNodo", "contenido", raiz);
      ```
    - *Atributos:*
      ```java
      hijo.setAttribute("nombreAtributo", "valor");
      ```
- **Guardar el XML en un archivo (usando Transformer):**
    ```java
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    // Configura las propiedades de salida según tus necesidades
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
    Source source = new DOMSource(documento);
    Result result = new StreamResult(new File("salida.xml"));
    transformer.transform(source, result);
    ```

### b) Abrir y manipular un documento XML existente
- **Cargar un XML existente:**
    ```java
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = dbf.newDocumentBuilder();
    Document documento = docBuilder.parse(new File("archivo.xml"));
    ```
- **Navegar y extraer información:**
    - *Por nombre de nodo:*
      ```java
      NodeList lista = documento.getElementsByTagName("nombreNodo");
      for (int i = 0; i < lista.getLength(); i++) {
          Element elem = (Element) lista.item(i);
          String texto = elem.getTextContent();
      }
      ```
    - *Por atributo:*
      ```java
      String valor = elem.getAttribute("nombreAtributo");
      ```
- **Modificar, agregar o eliminar nodos y guardar de nuevo (igual que en creación).**

### c) Helpers para agregar elementos al DOM
```java
public static Element creaElementoVacio(Document dom, String nombreElemento, Element padre) {
    Element creado = dom.createElement(nombreElemento);
    padre.appendChild(creado);
    return creado;
}
public static Element creaElementoLleno(Document dom, String nombreElemento, String contenido, Element padre) {
    Element creado = dom.createElement(nombreElemento);
    creado.setTextContent(contenido);
    padre.appendChild(creado);
    return creado;
}
```
**Ventaja:** Simplifican y reutilizan el código en la creación y manipulación del árbol XML.

### d) Propiedades más usadas del Transformer (`setOutputProperty`)
Permite ajustar el formato y características del XML/HTML generado:

| Propiedad                             | Constante                                    | ¿Para qué sirve?                                                      | Ejemplo valor                |
|---------------------------------------|----------------------------------------------|-----------------------------------------------------------------------|------------------------------|
| Indentación                           | `OutputKeys.INDENT`                          | Indentar el resultado para mejor legibilidad                          | `"yes"`                      |
| Codificación                          | `OutputKeys.ENCODING`                        | Codificación del archivo de salida                                    | `"UTF-8"`, `"ISO-8859-1"`    |
| Versión XML                           | `OutputKeys.VERSION`                         | Versión declarada en cabecera                                         | `"1.0"`                      |
| Omitir declaración XML                | `OutputKeys.OMIT_XML_DECLARATION`            | No incluir `<?xml ...?>`                                              | `"yes"`, `"no"`              |
| Tipo de salida                        | `OutputKeys.METHOD`                          | `"xml"`, `"html"`, `"text"`                                           | `"xml"`                      |
| Indentación avanzada                  | `"{http://xml.apache.org/xslt}indent-amount"`| Número de espacios para indentación (no estándar, aceptado por Xalan) | `"4"`                        |
| MediaType                             | `OutputKeys.MEDIA_TYPE`                      | Tipo MIME para HTTP/headers (opcional)                                | `"text/xml"`, `"text/html"`  |
| Doctype-public                        | `OutputKeys.DOCTYPE_PUBLIC`                  | Identificador público DOCTYPE                                         | `"PUBLIC_ID"`                |
| Doctype-system                        | `OutputKeys.DOCTYPE_SYSTEM`                  | Identificador sistema DOCTYPE                                         | `"SYSTEM_ID"`                |
| CDATA Section Elements                | `OutputKeys.CDATA_SECTION_ELEMENTS`          | Qué nodos escribir como CDATA                                         | Lista separada por espacios  |

**Ejemplo típico:**
```java
transformer.setOutputProperty(OutputKeys.INDENT, "yes");
transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
transformer.setOutputProperty(OutputKeys.METHOD, "xml");
```
> Modifica según el lector o propósito del archivo resultante.

---

## 2. Lectura y Visualización de XML
- **Carga el documento (ver 1.b)**
- **Recorre nodos y atributos:**  
  Usa `getElementsByTagName`, `getAttribute`, bucles para mostrar información en consola o en archivo.

## 3. Modificación de XML existente
- **Carga → modifica/agrega nodos (usando helpers) → guarda de nuevo.**
- Puedes actualizar atributos con `setAttribute` y cambiar valores con `setTextContent`.

## 4. Conversión y Transformación entre formatos (XSLT)
- **De XML a HTML:**
    ```java
    TransformerFactory factory = TransformerFactory.newInstance();
    Source xslt = new StreamSource(new File("estilo.xsl"));
    Transformer transformer = factory.newTransformer(xslt);
    Source xml = new StreamSource(new File("archivo.xml"));
    Result html = new StreamResult(new File("salida.html"));
    transformer.transform(xml, html);
    ```
- Utilizar una hoja XSL (`.xsl`) permite definir cómo se convierte o presenta el XML en HTML o en otros formatos.

## 5. Uso de JAXB para mapeo XML↔Objeto Java
- **Deserializar (Unmarshal):**
    ```java
    JAXBContext context = JAXBContext.newInstance(MiClase.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    MiClase obj = (MiClase) unmarshaller.unmarshal(new File("archivo.xml"));
    ```
- **Serializar (Marshal):**
    ```java
    Marshaller marshaller = context.createMarshaller();
    marshaller.marshal(obj, new File("nuevoArchivo.xml"));
    ```
- Útil para trabajar directamente con clases Java en vez de manipular nodos DOM.

## 6. Consulta avanzada con XPath
- **Buscar y contar nodos:**
    ```java
    XPathFactory xpathFactory = XPathFactory.newInstance();
    XPath xpath = xpathFactory.newXPath();
    String expresion = "count(//nodo)";
    Double resultado = (Double) xpath.evaluate(expresion, new InputSource(new FileInputStream("archivo.xml")), XPathConstants.NUMBER);
    ```
- **Permite consultas rápidas, conteo y extracción específica de información.**

---

## Flujo típico de trabajo
1. Crear o cargar un documento XML.
2. Navegar, modificar/agregar elementos usando helpers.
3. Guardar el resultado (XML, HTML, etc) usando `Transformer`.
4. (Avanzado) Usa JAXB/XPath para modelos o consultas sofisticadas.

---

## Recomendaciones para el alumno
- Es buena práctica usar funciones helper (`creaElementoVacio` y `creaElementoLleno`) para evitar duplicación al crear/agregar elementos.
- Familiarízate con la API DOM para construir y modificar XML de manera eficiente.
- Utiliza XSLT cuando necesites transformar la visualización del XML.
- Aprende lo básico de JAXB para proyectos donde el XML se mapea a objetos Java.
- Emplea XPath para realizar búsquedas y conteos complejos en tus documentos XML.
