package StepDefination;

import Pages.DialogContent;
import Utilities.Excelutility;
import Utilities.Excelutility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;

public class _06_ApachiPOI {
    DialogContent dc=new DialogContent();
    @When("user create country with apachiPOI")
    public void userCreateCountryWithApachiPOI() {

        ArrayList<ArrayList<String>> tablo= Excelutility. getListData("src/test/java/ApachePoi/resources/ApacheExcel2.xlsx,","testCitizen",2);

        for (ArrayList<String> satir: tablo ){


            dc.findAndClick("addButton");
            dc.findAndSend("nameInput", satir.get(0));
            dc.findAndSend("codeInput", satir.get(1));
            dc.findAndClick("saveButton");
        }

    }

    @Then("user Delete Citizenship With ApachiPOI")
    public void userDeleteCitizenshipWithApachiPOI() {

        // kaydettikkerini yine excelden okuyarak sil
        ArrayList< ArrayList< String > > tablo =
                Excelutility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx",
                        "testCitizen", 1);

        for (ArrayList< String > satir : tablo)
        {
            System.out.println("satir = " + satir);
            System.out.println("satir.get(0) = " + satir.get(0));

            dc.SearchAndDelete(satir.get(0));
            dc.findAndContainsText("successMessage","success");
        }

    }
}
