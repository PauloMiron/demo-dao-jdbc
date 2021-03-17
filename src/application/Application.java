package application;

import entities.Department;
import entities.Seller;
import model.dao.SellerDao;
import model.dao.DaoFactory;

import java.util.Date;

public class Application {
    public static void main(String[] args) {

        Department department = new Department(1,"Books");
        Seller seller = new Seller(21,"Bob","bob@gmail.com",new Date(),3000.00,department);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(department);
        System.out.println(seller);
    }
}
