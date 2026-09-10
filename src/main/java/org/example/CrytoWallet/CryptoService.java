package org.example.CrytoWallet;

import java.util.HashMap;
import java.util.Map;

public class CryptoService {
    final Map<Integer,Account> accounts;
    final Map<Integer,Transaction>transactions;

    public CryptoService(){
        accounts=new HashMap<>();
        transactions=new HashMap<>();
    }

    public void addAccount(Account account){
        accounts.put(account.userId,account);
    }

    public BalanceView viewBalance(int userId){
        Account account=accounts.get(userId);
        if(account!=null){
            return new BalanceView(account.getConfirmedBalance(),account.getAvailableBalance());
        }
        throw new IllegalStateException("Account not found");
    }

    public Transaction initiateTransfer(int fromUser,int toUser, double amount){

        Account sender=accounts.get(fromUser);
        sender.lock.lock();
        Transaction transaction;
        try{
            if(!sender.reserveFunds(amount)){
                throw new IllegalArgumentException("Insufficient funds");
            }
            transaction=new Transaction(fromUser,toUser,amount,TransactionStatus.PENDING);
            transactions.put(transaction.id,transaction);

            System.out.println("Transaction initiated from user " + fromUser+" to user " + toUser+" amount: " + amount);
            } finally {
            sender.lock.unlock();
        }
        return transaction;
    }

    public boolean confirmTransaction(int id){
        Transaction transaction=transactions.get(id);

        Account sender=accounts.get(transaction.fromUser);
        Account receiver=accounts.get(transaction.toUser);

        Account firstLock=null; Account secondLock=null;
        if(sender.hashCode()<receiver.hashCode()){
            firstLock=sender;
            secondLock=receiver;
        } else {
            firstLock=receiver;
            secondLock=sender;
        }
        firstLock.lock.lock();
        secondLock.lock.lock();

        try{

            if(transaction.status!=TransactionStatus.PENDING){
                throw new IllegalStateException("Transaction not in pending state");
            }
            sender.deductConfirmed(transaction.amount);
            receiver.addConfirmed(transaction.amount);
            transaction.status=TransactionStatus.SUCCESSFULL;
            System.out.println("✅ Transaction confirmed from user " + transaction.fromUser + " to user " + transaction.toUser + " amount: " + transaction.amount);
        } finally {
            firstLock.lock.unlock();
            secondLock.lock.unlock();
        }
        return true;
    }

    public boolean failTransaction(int id){
        Transaction transaction=transactions.get(id);

        Account sender=accounts.get(transaction.fromUser);
        sender.lock.lock();

        try{
            if(transaction.status!=TransactionStatus.PENDING){
                return true;
            }
            sender.releaseReserve(transaction.amount);
            transaction.status=TransactionStatus.FAILED;
            System.out.println("❌ Transaction failed from user " + transaction.fromUser + " to user " + transaction.toUser + " amount: " + transaction.amount);
        } finally {
            sender.lock.unlock();
        }
        return true;
    }


}
