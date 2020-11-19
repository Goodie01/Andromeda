package org.goodiemania.andromeda.domain;

public enum SystemStatus {
    OK("bg-success", "btn-outline-success"),
    CHECKING("bg-secondary", "btn-outline-secondary"),
    WARNING("bg-warning", "btn-outline-warning"),
    DANGER("bg-danger", "btn-outline-danger"),
    START_UP("bg-primary", "btn-outline-primary");

    private final String cardStyleClass;
    private final String buttonStyleClass;

    SystemStatus(final String cardStyleClass, final String buttonStyleClass) {
        this.cardStyleClass = cardStyleClass;
        this.buttonStyleClass = buttonStyleClass;
    }

    public String getCardStyleClass() {
        return cardStyleClass;
    }

    public String getButtonStyleClass() {
        return buttonStyleClass;
    }
}