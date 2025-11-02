import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Practicando con interfaces',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(
          seedColor: const Color.fromARGB(255, 0, 0, 0),
        ),
      ),
      home: const MyHomePage(title: 'Interfaz'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(centerTitle: true, title: const Text('Tablero Flutter')),
      body: Center(
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center, // Centra verticalmente
            crossAxisAlignment:
                CrossAxisAlignment.center, // Centra horizontalmente
            children: [
              Row(
                children: [
                  Column(children: [Text('Columna 1')]),
                  Column(
                    children: [
                      Icon(Icons.favorite, color: Colors.pink, size: 24.0),
                    ],
                  ),
                  Column(
                    children: [
                      const Image(
                        image: NetworkImage(
                          'https://flutter.github.io/assets-for-api-docs/assets/widgets/owl.jpg',
                        ),
                        width: 100,
                        height: 100,
                      ),
                    ],
                  ),
                ],
              ),
              Row(
                children: [
                  Column(children: [Text('Columna 1')]),

                  Column(
                    children: [
                      const Icon(
                        Icons.audiotrack,
                        color: Colors.green,
                        size: 30.0,
                      ),
                    ],
                  ),
                  Column(
                    children: [
                      const Image(
                        image: NetworkImage(
                          'https://flutter.github.io/assets-for-api-docs/assets/widgets/owl.jpg',
                        ),
                        width: 100,
                        height: 100,
                      ),
                    ],
                  ),
                ],
              ),
              Row(
                children: [
                  Column(children: [Text('Columna 1')]),
                  Column(
                    children: [
                      const Icon(
                        Icons.audiotrack,
                        color: Colors.green,
                        size: 30.0,
                      ),
                    ],
                  ),
                  Column(
                    children: [
                      const Image(
                        image: NetworkImage(
                          'https://flutter.github.io/assets-for-api-docs/assets/widgets/owl.jpg',
                        ),
                        width: 100,
                        height: 100,
                      ),
                    ],
                  ),
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }
}
