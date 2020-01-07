package com.rlg.challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * Create TransactionException, DigitalWallet, and DigitalWalletTransaction classes here.
 */
class TransactionException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String errorCode;
	
	public TransactionException(String errorMessage, String errorCode) {
		super(errorMessage);
		
		this.errorCode		= errorCode;
	}
	
	public String getErrorCode() {
		return this.errorCode;
	}
	
}

class DigitalWallet {
	
	private String	walletId;
	private String	userName;
	private String	userAccessCode;
	private int		walletBallance;
	
	public DigitalWallet(String walletId, String userName) {
		this.walletId		= walletId;
		this.userName		= userName;
	}
	
	public DigitalWallet(String walletId, String userName, String userAccessCode) {
		this.walletId		= walletId;
		this.userName		= userName;
		this.userAccessCode	= userAccessCode;
	}
	
	public String getWalletId() {
		return this.walletId;
	}
	
	public String getUsername() {
		return this.userName;
	}
	
	public String getUserAccessToken() {
		return this.userAccessCode;
	}
	
	public int getWalletBalance() {
		return this.walletBallance;
	}
	
	public void setWalletBalance(int walletBalance) {
		this.walletBallance = walletBalance;
	}
}

class DigitalWalletTransaction {
	
	public void addMoney(DigitalWallet digitalWallet, int amount) throws TransactionException {
		
		if(!this.isAuthenticatedUser(digitalWallet)) {
			throw new TransactionException("User not authorized", "USER_NOT_AUTHORIZED");
		}
		
		if(!this.isValidAmount(amount)) {
			throw new TransactionException("Amount should be greater than zero", "INVALID_AMOUNT");
		}
		
		digitalWallet.setWalletBalance(digitalWallet.getWalletBalance() + amount);
	}

	public void payMoney(DigitalWallet digitalWallet, int amount) throws TransactionException {

		if(!this.isAuthenticatedUser(digitalWallet)) {
			throw new TransactionException("User not authorized", "USER_NOT_AUTHORIZED");
		}
		
		if(!this.isValidAmount(amount)) {
			throw new TransactionException("Amount should be greater than zero", "INVALID_AMOUNT");
		}

		if(!this.isValidWalletBallance(digitalWallet, amount)) {
			throw new TransactionException("Insufficient balance", "INSUFFICIENT_BALANCE");
		}

		digitalWallet.setWalletBalance(digitalWallet.getWalletBalance() - amount);
	}
	
	private boolean isAuthenticatedUser(DigitalWallet digitalWallet) {
		return digitalWallet.getUserAccessToken() != null;
	}

	private boolean isValidAmount(int amount) {
		return amount > 0;
	}

	private boolean isValidWalletBallance(DigitalWallet digitalWallet, int amount) {
		return digitalWallet.getWalletBalance() >= amount;
	}
}

public class DigitalWalletChallengeSolution {

    private static final Scanner INPUT_READER = new Scanner(System.in);
    private static final DigitalWalletTransaction DIGITAL_WALLET_TRANSACTION = new DigitalWalletTransaction();

    private static final Map<String, DigitalWallet> DIGITAL_WALLETS = new HashMap<>();

    public static void main(String[] args) {
        int numberOfWallets = Integer.parseInt(INPUT_READER.nextLine());
        while (numberOfWallets-- > 0) {
            String[] wallet = INPUT_READER.nextLine().split(" ");
            DigitalWallet digitalWallet;

            if (wallet.length == 2) {
                digitalWallet = new DigitalWallet(wallet[0], wallet[1]);
            } else {
                digitalWallet = new DigitalWallet(wallet[0], wallet[1], wallet[2]);
            }

            DIGITAL_WALLETS.put(wallet[0], digitalWallet);
        }

        int numberOfTransactions = Integer.parseInt(INPUT_READER.nextLine());
        while (numberOfTransactions-- > 0) {
            String[] transaction = INPUT_READER.nextLine().split(" ");
            DigitalWallet digitalWallet = DIGITAL_WALLETS.get(transaction[0]);

            if (transaction[1].equals("add")) {
                try {
                    DIGITAL_WALLET_TRANSACTION.addMoney(digitalWallet, Integer.parseInt(transaction[2]));
                    System.out.println("Wallet successfully credited.");
                } catch (TransactionException ex) {
                    System.out.println(ex.getErrorCode() + ": " + ex.getMessage() + ".");
                }
            } else {
                try {
                    DIGITAL_WALLET_TRANSACTION.payMoney(digitalWallet, Integer.parseInt(transaction[2]));
                    System.out.println("Wallet successfully debited.");
                } catch (TransactionException ex) {
                    System.out.println(ex.getErrorCode() + ": " + ex.getMessage() + ".");
                }
            }
        }

        System.out.println();

        List<String> digitalWalletIds = new ArrayList<>();
        digitalWalletIds.addAll(DIGITAL_WALLETS.keySet());

        Collections.sort(digitalWalletIds);
        for (String digitalWalletId: digitalWalletIds) {
            DigitalWallet digitalWallet = DIGITAL_WALLETS.get(digitalWalletId);
            System.out.println(digitalWallet.getWalletId()
                    + " " + digitalWallet.getUsername()
                    + " " + digitalWallet.getWalletBalance());
        }
    }
}