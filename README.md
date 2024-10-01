# MNIST in Java from scratch
This is my **MNIST digit** classifier written from scratch in Java, and visualised using the **Java swing** library. Dataset not included.

It ain't pretty, but it works!

<img width="498" alt="Screenshot 2024-10-01 at 01 25 06" src="https://github.com/user-attachments/assets/3d40db39-aa8b-45e5-bb08-acae40a29cde">
<img width="406" alt="Screenshot 2024-10-01 at 01 27 47" src="https://github.com/user-attachments/assets/3e6d2859-e8fe-4954-b2cf-7a4762ca1df3">

## Future plans
1. Add a convolutional stage
2. Explore visualising cost graph
3. Add ability to load existing weights
# MNIST Classifier Neural Network in Java

![License](https://img.shields.io/badge/license-MIT-brightgreen)

## Overview

This project implements a neural network classifier in Java to recognize handwritten digits from the MNIST dataset. The goal is to explore machine learning concepts, understand neural network architecture, and to develop my own familiarity with Java.

## Features

- Fully connected feedforward neural network
- Training on the MNIST dataset (70,000 images of handwritten digits)
- Support for configurable layers and neurons
- Backpropagation algorithm for training
- Evaluation metrics for assessing model performance

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Maven (for managing dependencies)
- MNIST dataset (available for download as a .csv here: https://www.kaggle.com/datasets/oddrationale/mnist-in-csv)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/dustmodebros/mnist_in_java.git
   ```

2. Navigate to the project directory:

   ```bash
   cd mnist-classifier-java
   ```

3. Build the project using Maven:

   ```bash
   mvn clean package
   ```

### Dataset

The MNIST dataset is included in the project. For further details on the dataset, visit [Yann LeCun's website](http://yann.lecun.com/exdb/mnist/).

## Usage

1. Run the main application:

   ```bash
   java -cp target/mnist-classifier-java-1.0-SNAPSHOT.jar com.example.Main
   ```

2. Adjust the parameters in the `Main` class to configure the neural network architecture, learning rate, epochs, and batch size.

### Training

The model is trained using the MNIST training set, and you can monitor the training progress in the console output.

### Evaluation

After training, the model is evaluated using the MNIST test set, and accuracy metrics are printed to the console.

## Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue to discuss any improvements.

### Steps to Contribute

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeature`).
3. Make your changes and commit them (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Open a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Special thanks to Yann LeCun and the MNIST dataset contributors for providing the dataset.
- Inspired by various resources on machine learning and neural networks.

---

Feel free to reach out with any questions or feedback!
