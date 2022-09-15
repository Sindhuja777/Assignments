package com.maveric.bankapp;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HeadOffice {

	public static AtomicInteger BRANCH_ID_GENERATOR = new AtomicInteger(0);
	// private List<Branch> branches;
	static Map<String, Branch> branches = new LinkedHashMap<>();

	public void createBranch(String branchId) {
		Branch branch = new Branch();
		branchId = Integer.toString(BRANCH_ID_GENERATOR.incrementAndGet());
		branch.setBranchId(branchId);
		branches.put(branchId, branch);
	}

	public Branch getBranchById(String branchId) throws BankException {
		if (!branches.containsKey(branchId)) {
			throw new BankException("No Branch Found with the given BranchId " + branchId);
		}
		return branches.get(branchId);
	}

	public List<Branch> getAllBranches() {
		List<Branch> allBranches = new ArrayList<>();
		for (String branchId : branches.keySet()) {
			allBranches.add(branches.get(branchId));

//			allBranches.add(branches.get(branchId));
		}
		return allBranches;
	}
}
