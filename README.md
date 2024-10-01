# MNIST in Java from scratch
![License](https://img.shields.io/badge/license-MIT-brightgreen)

This is my **MNIST digit** classifier written from scratch in Java, and visualised using the **Java swing** library. Dataset not included.

It ain't pretty, but it works!

<img width="498" alt="Screenshot 2024-10-01 at 01 25 06" src="https://github.com/user-attachments/assets/3d40db39-aa8b-45e5-bb08-acae40a29cde">
<img width="406" alt="Screenshot 2024-10-01 at 01 27 47" src="https://github.com/user-attachments/assets/3e6d2859-e8fe-4954-b2cf-7a4762ca1df3">

## Overview

This project implements a neural network classifier in Java to recognize handwritten digits from the MNIST dataset. The goal is to explore machine learning concepts, understand neural network architecture, and to develop my own familiarity with Java.

## Features

- Fully connected feedforward neural network
- Training on the MNIST dataset (70,000 images of handwritten digits)
- Support for configurable layers and neurons
- Backpropagation algorithm for training
- Evaluation metrics for assessing model performance
- Visualisation using Java Swing

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

The MNIST dataset is not included in the project due to size limitations. It can be downloaded from several sources, such as https://www.kaggle.com/datasets/oddrationale/mnist-in-csv (which is what I used).

## Usage

1. Run the main application:

   ```bash
   java -cp target/mnist-classifier-java-1.0-SNAPSHOT.jar com.example.Main
   ```

2. Adjust the parameters in the `Main` class to configure the neural network architecture, learning rate, epochs, and batch size.

### Training

The model is trained using the MNIST training set, and you can monitor the training progress in the console output via .

### Evaluation

After training, the model is evaluated using the MNIST test set, and accuracy metrics are printed to the console.

## Future plans
1. Add a convolutional stage
2. Explore visualising cost graph
3. Add ability to load existing weights
## Acknowledgments

- Special thanks to Yann LeCun and the MNIST dataset contributors for providing the dataset.
- Inspired by various resources on machine learning and neural networks.

---

Feel free to reach out with any questions or feedback!
