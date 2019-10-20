package am.testing.qe.factory.pages;

public interface IBasePage<Main extends IBasePage<Main>> {

    Main getPage();

    Main init();

}
