package com.dev118.jexample.app0.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PrintCamel extends Remote {

	public void print(String content) throws RemoteException;

	public String format(String content) throws RemoteException;
}
