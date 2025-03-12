package stockmarket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.TreeSet;
import java.util.stream.StreamSupport;

public class Main {

  private static final List<Transaction> TRANSACTIONS = new ArrayList<>();

  // Stream of reverse Iterator or just reversed? ( Stock Market )
  public static void main(String[] args) {
    TRANSACTIONS.add(new Transaction(100)); // Buy
    TRANSACTIONS.add(new Transaction(-50)); // Sell
    TRANSACTIONS.add(new Transaction(200)); // Buy
    TRANSACTIONS.add(new Transaction(-100)); // Sell
    TRANSACTIONS.add(new Transaction(300)); // Buy
    TRANSACTIONS.add(new Transaction(150)); // Buy
    TRANSACTIONS.add(new Transaction(-200)); // Sell

    System.out.println("Analyse of last 4 transactions: " + oldStream(4));
    System.out.println("Analyse of last 4 transactions: " + newStream(4));
  }

  static String oldStream(int count) {
    return StreamSupport.stream(
            Spliterators.spliterator(
                new Iterator<Transaction>() {

                  final ListIterator<Transaction> iterator
                      = TRANSACTIONS.listIterator(TRANSACTIONS.size());

                  @Override
                  public boolean hasNext() {
                    return iterator.hasPrevious();
                  }

                  @Override
                  public Transaction next() {
                    return iterator.previous();
                  }
                },
                TRANSACTIONS.size(), Spliterator.ORDERED), false)
        .limit(count)
        .mapToDouble(Transaction::amount)
        .sum() > 0 ? "BUY" : "SELL";

  }

  private static String newStream(int count) {
    return TRANSACTIONS.reversed().stream()
        .limit(count)
        .mapToDouble(Transaction::amount)
        .sum() > 0 ? "BUY" : "SELL";
  }
}
