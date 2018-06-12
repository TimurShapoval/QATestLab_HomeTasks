package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.GeneralActions;
import org.openqa.selenium.WebDriver;

public class CreateCategoryTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {

        GeneralActions generalActions = new GeneralActions(getConfiguredDriver());
        // TODO prepare driver object
        // ...

        // login
        generalActions.login("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");


        // create category

        // check that new category appears in Categories table

        // finish script

        generalActions.createCategory("NewCategory_ByTimur");


    }
}
