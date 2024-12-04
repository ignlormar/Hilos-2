package elJefe;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Saludo saludo = new Saludo();
        Empleado jefe = new Empleado("Javier", saludo, true);
        Empleado emp1 = new Empleado("Enrique", saludo, false);
        Empleado emp2 = new Empleado("Alex", saludo, false);
        Empleado emp3 = new Empleado("Pruden", saludo, false);
        Empleado emp4 = new Empleado("Emi", saludo, false);
        Empleado emp5 = new Empleado("Nacho", saludo, false);

        emp1.start();
        emp2.start();
        emp3.start();
        emp4.start();
        emp5.start();
        Thread.sleep(500);
        jefe.start();

        jefe.join();
        emp1.join();
        emp2.join();
        emp3.join();
        emp4.join();
        emp5.join();
    }
}
