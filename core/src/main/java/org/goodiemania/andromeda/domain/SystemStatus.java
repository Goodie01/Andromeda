package org.goodiemania.andromeda.domain;

public enum SystemStatus {
    OK("bg-green-300 hover:bg-green-700", "btn-outline-success"),
    CHECKING("bg-blue-300 hover:bg-blue-700", "btn-outline-secondary"),
    WARNING("bg-yellow-300 hover:bg-yellow-700", "btn-outline-warning"),
    DANGER("bg-red-300 hover:bg-red-700", "btn-outline-danger"),
    START_UP("bg-purple-300 hover:bg-purple-700", "btn-outline-primary");

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