package stockmarket;

record Transaction(double amount) {

  @Override
  public String toString() {
    return String.format("Transaction amount: %.2f", amount);
  }

}
