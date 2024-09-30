package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.example.Model.Product;

import java.util.List;

public class PracticeDataTables {

    @Given("A Product Exists")
    public void a_product_exists(DataTable dataTable){
        List<Product> productList = dataTable.asList(Product.class);
        System.out.println("Product List: ");
        System.out.println(productList);

    }
}
