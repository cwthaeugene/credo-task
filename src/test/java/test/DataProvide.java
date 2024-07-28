package test;

import org.testng.annotations.DataProvider;

public class DataProvide
{
    @DataProvider(name = "assertionProvider")
    public Object[][] createData()
    {
        return new Object[][]{
                { "სისტემაში შესვლა", "მომხმარებელი", "პაროლი", "შესვლა", "მონაცემები არასწორია", "Georgian" },
                { "სისტემათეისგა სგა ლიზი", "მომხმარებელ/მ\uE169\uE156მ\uE003რი", "პაროლ/ლუჰვემ სიტყვა", "სგა ლიზი", "მონაცემოლ სწორ დემეგ ლი", "Svanuri" },
                { "სისტემაშა მიშულა", " მახვარებუ", "პაროლი", "მიშულა", "მუნაჩემეფი ვა რე თინუ", "Megruli" }
        };
    }
}
