package isp.lab5.exercise1;

public class ChangePin extends Transaction{
    private String oldPin;
    private String newPin;

    public ChangePin(String oldPin, String newPin) {
        this.oldPin = oldPin;
        this.newPin = newPin;
    }

    @Override
    String execute() {
        Card accountCard = account.getCard();

        if(accountCard.getCardId() == oldPin){
            accountCard.setPin(newPin);
            return "Pin successfully changed!";
        }
        return "Old pin doesn't match!";
    }
}
