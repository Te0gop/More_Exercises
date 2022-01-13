package hr.main;

import hr.logging.ConsoleLogger;
import hr.persistence.EmployeeFileSerializer;
import hr.persistence.EmployeeRepository;
import hr.personnel.Employee;
import hr.taxes.TaxCalculator;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class CalculateTaxesMain {
    public static void main(String[] args) {
        // Create dependencies
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepository repository = new EmployeeRepository(employeeFileSerializer);

        // Grab employees
        List<Employee> employees = repository.findAll();

        // Calculate taxes
        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        /*
        The problem here is that if we have new employee types we have to modify the main method or other classes.
        Here we used Open-Closed principle to separate the logic.
        In taxes packages we have to create FullTimeTaxCalculator, PartTimeTaxCalculator and InternTaxCalculator.
        We have to build TaxCalculatorFactory class with Factory pattern inside.
        This will help to return true instance of employee (Full-Time, Part-Time or Intern).
        More in 'refactored'.
        */

        TaxCalculator taxCalculator = new TaxCalculator();

        double totalTaxes = 0;
        for (Employee employee: employees){

            // compute individual tax
            double tax = taxCalculator.calculate(employee);
            String formattedTax = currencyFormatter.format(tax);
            consoleLogger.writeInfo(employee.getFullName() + " taxes: " + formattedTax);

            // add to company total taxes
            totalTaxes += taxCalculator.calculate(employee);
        }
        consoleLogger.writeInfo("Total taxes = " + currencyFormatter.format(totalTaxes));
    }
}
