package gui;

import model.Account;
import model.Client;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JLabel header;
    private JPanel expensesPanel;
    private JPanel balancePanel;
    private JPanel spendCategoriesPanel;
    private JPanel cardPanel;
    private JButton transactionHistoryButton;
    private JButton loanButton;
    private JButton createCardButton;

    private Account account;

    public MainFrame(Client client){
        JFrame mainFrame = new Template();

//      Initializing components
        header = Utils.setHeader("Welcome back " + "<username>");
        expensesPanel = new ExpensesPanel();
        balancePanel = new BalancePanel();
        spendCategoriesPanel = new SpendCategoriesPanel();
        cardPanel = new CardPanel();
        transactionHistoryButton = new JButton("Transaction History");
        loanButton = new JButton("Apply for a loan");
        createCardButton = new JButton("Create your new card today!");

//      Setting up header
        header.setBounds(250, 50, 1000, 100);

//      Setting up loanButton
        loanButton.setBounds(850, 670, 200, 50);
        loanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                //new LoanFrame();
            }
        });

//      Setting up createCard button
        createCardButton.setBounds(370, 710, 250, 30);
        createCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateNewCardFrame(account.getID());
                mainFrame.dispose();
            }
        });

//      Creating account
        account = new Account(0, "", "", client.getUsername());

//      Adding components to the frame
        mainFrame.add(header);
        mainFrame.add(expensesPanel);
        mainFrame.add(balancePanel);
        mainFrame.add(spendCategoriesPanel);
        mainFrame.add(loanButton);
        mainFrame.add(cardPanel);
        mainFrame.add(createCardButton);

//      Basic settings
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class CardPanel extends JPanel {
    private JLabel cardLabel;
    private JLabel cardIcon;

    public CardPanel() {
        cardLabel = new JLabel("Cards");
        cardIcon = new JLabel();

//      Setting up cardLabel
        cardLabel.setFont(new Font("Courier", Font.BOLD, 20));

//      Setting up cardIcon
        cardIcon.setSize(50, 50);
        cardIcon.setIcon(Utils.setLabelIcon("src/main/resources/images/card.png", cardIcon));

//      Basic Settings
        setBounds(320, 480, 350, 200);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(cardIcon);

//        layoutComponents();
    }

//    public LayoutManager layoutComponents() {
//        setLayout(new GridBagLayout());
//
//        GridBagConstraints gc = new GridBagConstraints();
//
//        gc.gridy = 0;
//        gc.gridx = 0;
//        add(cardIcon, gc);
//
//        return null;
//    }
}

class SpendCategoriesPanel extends JPanel {
    private JButton spendCategoriesButton;
    private ChartPanel chartPanel;


    public SpendCategoriesPanel() {

//      Basic settings
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBounds(700, 200, 470, 400);

//      Setting up the Chart
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Supermarket", 40);
        dataset.setValue("Transport", 35);
        dataset.setValue("Pharmacy", 25);

        JFreeChart chart = ChartFactory.createPieChart(
                "Spend Categories", // chart title
                dataset, // data
                true, // include legend
                true, // tooltips
                false // urls
        );
//      Setting the categories
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionPaint("Category 1", Color.BLUE);
        plot.setSectionPaint("Category 2", Color.GREEN);
        plot.setSectionPaint("Category 3", Color.ORANGE);

//      Adding the chartPanel to the panel
        chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        chartPanel.setPreferredSize(new Dimension(400, 300));

//      Setting up spendCategoriesButton
        spendCategoriesButton = new JButton("Spend categories");
        spendCategoriesButton.setFont(new Font("Courier", Font.PLAIN, 12));
        spendCategoriesButton.setPreferredSize(new Dimension(180, 50));

        layoutComponents();

    }

    public LayoutManager layoutComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;
        gc.gridx = 0;
        add(chartPanel, gc);

        gc.gridy++;
        gc.insets = new Insets(20, 0, 0, 0);
        add(spendCategoriesButton, gc);


        return null;
    }
}

class BalancePanel extends JPanel{
    private JLabel header;
    private JLabel balance;
    private JButton newTransactionButton;

    public BalancePanel() {
//      Initializing components
        header = Utils.setHeader("Your account balance");
        balance = new JLabel("1500$");
        newTransactionButton = new JButton("New Transaction");

//      Setting up header
        header.setFont(new Font("Courier", Font.PLAIN, 23));

//      Setting up balance
        balance.setFont(new Font("Courier", Font.PLAIN, 55));

//      Basic settings
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBounds(350, 200, 300, 200);

        layoutComponents();
    }

    public LayoutManager layoutComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.PAGE_START;
        gc.insets = new Insets(0, 0, 30, 0);
        add(header, gc);

        gc.gridy++;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(balance, gc);

        gc.gridy++;
        gc.anchor = GridBagConstraints.PAGE_END;
        gc.insets = new Insets(30, 0, 0, 0);
        add(newTransactionButton, gc);

        return null;
    }
}

class ExpensesPanel extends JPanel {
    private JLabel header;
    private JScrollPane scrollPane;
    private JList expenseList;
    private DefaultListModel listModel;
    private JButton transactionHistoryButton;
    public ExpensesPanel() {

//      Initializing components
        header = Utils.setHeader("Your expenses");
        transactionHistoryButton = new JButton();

//      Setting up header
        header.setFont(new Font("Courier", Font.PLAIN, 18));

//      Setting up scrollPane
        expenseList = new JList();
        listModel = new DefaultListModel();
        expenseList.setModel(listModel);
        scrollPane = new JScrollPane(expenseList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        listModel.addElement("• Expense 1, 12,00$");
        listModel.addElement("• Expense 2, 20,00$");
        listModel.addElement("• Expense 3, 300,00$");
        listModel.addElement("• Expense 4, 300,00$");
        listModel.addElement("• Expense 5, 1300,00$");
        listModel.addElement("• Expense 6, 11300,00$");
        listModel.addElement("• Expense 7, 200,00$");
        listModel.addElement("• Expense 8, 1300,00$");
        listModel.addElement("• Expense 9, 300,00$");
        listModel.addElement("• Expense 10, 3100,00$");
        listModel.addElement("• Expense 12, 3100,00$");
        listModel.addElement("• Expense 13, 300,00$");

//      Setting up transaction history button
        transactionHistoryButton.setFont(new Font("Courier", Font.PLAIN, 12));
        transactionHistoryButton.setPreferredSize(new Dimension(180, 50));
        transactionHistoryButton.setText("<html><center>"+"Check your transaction"+"<br>"+"history"+"</center></html>");
        transactionHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Waiting for transaction history frame
            }
        });


//      Basic settings
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBounds(50, 200, 190, 300);

        layoutComponents();

    }

    public LayoutManager layoutComponents() {
        setLayout(new FlowLayout(1, 10, 28));


        add(header);
        add(scrollPane);
        add(transactionHistoryButton);

        return null;
    }
}
