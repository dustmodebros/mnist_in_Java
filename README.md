# MNIST in Java from scratch
![License](https://img.shields.io/badge/license-MIT-brightgreen)

This is my **MNIST digit** classifier written from scratch in Java, and visualised using the **Java swing** library. Dataset not included!

## Overview

This project implements a neural network classifier in Java to recognize handwritten digits from the MNIST dataset. My goal in creating this project was to explore machine learning concepts, understand neural network architecture, and to develop my own familiarity with Java.

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
   git clone https://github.com/dustmodebros/mnist_in_Java.git
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

2. Set the `trainSet` and `testSet` variables to the path to the downloaded .csv files in the `Main` class to load the datasets.

3. Adjust the parameters in the `Main` class to configure the neural network architecture and learning rate.

### Training

The model is trained using the MNIST training set, and you can monitor the training progress (current cost, averaged cost over 100 training iterations) in the console output, as well as watch the network's predicitons become more accurate in real time.

<img width="498" alt="Screenshot 2024-10-01 at 01 25 06" src="https://github.com/user-attachments/assets/3d40db39-aa8b-45e5-bb08-acae40a29cde">

### Evaluation

After training, the model is evaluated using the MNIST test set, and accuracy metrics are printed to the console.

## Future plans
1. Add a convolutional stage
2. Explore visualising cost graph
3. Add ability to load existing weights from an already trained network.
   
## Acknowledgments

- Thanks to Yann LeCun and the MNIST dataset contributors for providing the dataset.
- This project was inspired by various resources on machine learning and neural networks, Especially those by Sebastian Lague (https://youtu.be/hfMk-kjRv4c?si=rVrl2Yi7CzuAaA5G) and 3Blue1Brown (https://www.youtube.com/watch?v=aircAruvnKk&list=PLZHQObOWTQDNU6R1_67000Dx_ZCJB-3pi)

---

Feel free to reach out with any questions or feedback!
