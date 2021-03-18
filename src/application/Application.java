
package application;

import entities.Department;
import entities.Seller;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Application{

 public static void main(String[]args){

        SellerDao sellerDao = DaoFactory.createSellerDao();
        Scanner scanner = new Scanner(System.in);

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
        seller = sellerDao.findById(2);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update Completed");

        System.out.println("\n===TESTE 6: seller Delete ===");
        System.out.print("Inter id for delete test: ");
        int id = scanner.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete Completed");


     System.out.println("_____________________________________________________________________________________-");

     DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

     System.out.println("\n===TESTE 1: Department Insert===");
     Department newDepartment = new Department(null, "Music");
     departmentDao.insert(newDepartment);
     System.out.println("Inserted! New id = " + newDepartment.getId());

     System.out.println("\n===TESTE 2: Department Update===");
     department = departmentDao.findById(1);
     department.setName("Teste");
     departmentDao.update(department);
     System.out.println("Update Completed");

     System.out.println("\n===TESTE 5: Department Delete ===");
     System.out.print("Inter id for delete test: ");
     int idd = scanner.nextInt();
     departmentDao.deleteById(idd);
     System.out.println("Delete Completed");
     scanner.close();


     System.out.println("===TESTE 4: Department findById===");
     Department department1 = departmentDao.findById(3);
     System.out.println(department1);

     System.out.println("\n===TESTE 5: Department findAll===");
     List<Department> list1 = departmentDao.findAll();
     for (Department obj : list1){
         System.out.println(obj);
     }

     scanner.close();


    }
}

