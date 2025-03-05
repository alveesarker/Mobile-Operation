package com.example.mobileoperation;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MobileOperatorViewController {
    @javafx.fxml.FXML
    private Text showBestValueText;
    @javafx.fxml.FXML
    private TextField packageNameTextField;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, String> packageNameColumn;
    @javafx.fxml.FXML
    private ComboBox<String> availabilityComboBox;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, Float> dataAmountColumn;
    @javafx.fxml.FXML
    private Text showErrorText;
    @javafx.fxml.FXML
    private TextField dataAmountTextField;
    @javafx.fxml.FXML
    private DatePicker offerDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> validityComboBox;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, LocalDate> offerDateColumn;
    @javafx.fxml.FXML
    private ComboBox<String> filterValidityComboBox;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, String> availabilityColumn;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, String> validityColumn;
    @javafx.fxml.FXML
    private TextField priceTextField;
    @javafx.fxml.FXML
    private TableView<DataPackage> packageTableView;
    @javafx.fxml.FXML
    private TextField filterPriceTextField;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, Float> priceColumn;

    private final List<DataPackage> dataPackages = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        validityComboBox.getItems().addAll("3 days", "7 days", "15 days", "30 days", "Unlimited");
        availabilityComboBox.getItems().addAll("App only", "Recharge only", "App and Recharge");
        filterValidityComboBox.getItems().addAll("3 days", "7 days", "15 days", "30 days", "Unlimited");

        availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));
        packageNameColumn.setCellValueFactory(new PropertyValueFactory<>("packageName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        validityColumn.setCellValueFactory(new PropertyValueFactory<>("validity"));
        offerDateColumn.setCellValueFactory(new PropertyValueFactory<>("offerEnds"));
        dataAmountColumn.setCellValueFactory(new PropertyValueFactory<>("dataAmount"));
    }

    @javafx.fxml.FXML
    public void handleResultFilterOnClick() {
        packageTableView.getItems().clear();
        for (DataPackage d : dataPackages) {
            packageTableView.getItems().add(d);
        }

    }

    @javafx.fxml.FXML
    public void handleBestPriceButtonOnClick() {
        DataPackage lowest = dataPackages.getFirst();
        for (DataPackage d : dataPackages) {
            if (lowest.getPrice() / lowest.getDataAmount() > d.getPrice() / d.getDataAmount()) {
                lowest = d;
            }
        }
        showBestValueText.setText("Best value package is " + lowest.getPackageName());
    }

    @javafx.fxml.FXML
    public void handleCreatePackageButtonOnclick() {
        String packageName = packageNameTextField.getText();
        String dataAmount = dataAmountTextField.getText();
        String validity = validityComboBox.getValue();
        String availability = availabilityComboBox.getValue();
        LocalDate offerEnds = offerDatePicker.getValue();
        String price = priceTextField.getText();

        for (DataPackage d : dataPackages) {
            if (d.getPackageName().equals(packageNameTextField.getText())) {
                showErrorText.setText("Duplicate package name!");
                return;
            }
        }
        if (packageName.isEmpty() || dataAmount.isEmpty() || validity == null || availability == null || offerEnds == null || price.isEmpty()) {
            showErrorText.setText("Fill up inputs properly.");
        } else {
            dataPackages.add(
                    new DataPackage(
                            packageNameTextField.getText(),
                            Float.parseFloat(dataAmountTextField.getText()),
                            validityComboBox.getValue(),
                            availabilityComboBox.getValue(),
                            offerDatePicker.getValue(),
                            Float.parseFloat(priceTextField.getText())
                    )
            );
            packageTableView.getItems().clear();
            for (DataPackage d : dataPackages) {
                packageTableView.getItems().add(d);
            }
        }
    }

    @javafx.fxml.FXML
    public void handleFilterOnClick() {
        packageTableView.getItems().clear();
        for (DataPackage d : dataPackages) {
            if (filterValidityComboBox.getValue().equals(d.getValidity()) && Integer.parseInt(filterPriceTextField.getText()) >= d.getPrice()) {
                packageTableView.getItems().add(d);
            }
        }
    }
}