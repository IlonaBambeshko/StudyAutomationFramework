package com.stormnet.listeners;

import org.testng.IExecutionListener;

public class CustomExecListener implements IExecutionListener {
	@Override
	public void onExecutionStart() {
		System.out.println("Exec started");
	}

	@Override
	public void onExecutionFinish() {
		System.out.println("Exec finish");
	}
}
