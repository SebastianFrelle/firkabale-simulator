import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    SimulationController simulation = SimulationController.getInstance();
    Scanner scan = new Scanner(System.in);
    int iterations = scan.nextInt();
    double result = simulation.run(iterations);
    System.out.println(result);
  }
}