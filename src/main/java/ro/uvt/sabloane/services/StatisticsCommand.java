package ro.uvt.sabloane.services;

public class StatisticsCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Getting book statistics...");

        if (DocumentManager.getInstance().getBook() != null) {
            BookStatistics s = new BookStatistics();
            DocumentManager.getInstance().getBook().accept(s);
            s.print();
        }
        else
            System.out.println("There is no book");
    }
}