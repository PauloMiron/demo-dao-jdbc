package application;

import entities.Department;
import entities.Seller;
import model.dao.DaoFactory;
import model.dao.SellerDao;

import java.util.Date;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("===TESTE 1: seller findById===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);



        System.out.println("\n===TESTE 2: seller findByDepartment===");
        Department department = new Department(2,null);
        List<Seller> list = sellerDao.findByDepartment(department);


        System.out.println("\n===TESTE 3: seller findAll===");
        list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n===TESTE 4: seller Insert===");
        Seller newSeller = new Seller(null, "Greg", "Greg@email", new Date(), 400.00,department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n===TESTE 5: seller Update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update Completed");
    }
}
