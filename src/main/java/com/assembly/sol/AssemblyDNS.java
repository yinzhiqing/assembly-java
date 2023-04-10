package com.assembly.sol;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class AssemblyDNS extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506119e9806100206000396000f3fe608060405234801561001057600080fd5b50600436106101425760003560e01c80639010d07c116100b8578063ca15c8731161007c578063ca15c87314610269578063ccf1454a1461027c578063d547741f1461028f578063dbfcec10146102a2578063e63ab1e9146102c3578063ec87621c146102cb57610142565b80639010d07c1461021357806391d148541461023357806395d89b4114610246578063a217fddf1461024e578063a815ff151461025657610142565b80632f2ff15d1161010a5780632f2ff15d146101c057806336568abe146101d55780633f4ba83a146101e85780634cd88b76146101f05780635c975abb146102035780638456cb591461020b57610142565b806301ffc9a71461014757806306661abd1461017057806306fdde0314610185578063248a9ca31461019a578063261a323e146101ad575b600080fd5b61015a610155366004611407565b6102d3565b60405161016791906115f9565b60405180910390f35b610178610300565b6040516101679190611604565b61018d610307565b604051610167919061160d565b6101786101a83660046113a3565b610399565b61015a6101bb36600461142f565b6103ae565b6101d36101ce3660046113bb565b6103da565b005b6101d36101e33660046113bb565b610401565b6101d3610423565b6101d36101fe3660046114ad565b61046c565b61015a6104ec565b6101d36104f5565b6102266102213660046113e6565b610533565b60405161016791906115cb565b61015a6102413660046113bb565b610554565b61018d61057f565b61017861058e565b6101d361026436600461146a565b610593565b6101786102773660046113a3565b610792565b61022661028a36600461142f565b6107a9565b6101d361029d3660046113bb565b61081f565b6102b56102b03660046113a3565b610829565b604051610167929190611620565b61017861090d565b61017861091f565b60006001600160e01b03198216635a05180f60e01b14806102f857506102f882610943565b90505b919050565b6101015490565b606060fb80546103169061192c565b80601f01602080910402602001604051908101604052809291908181526020018280546103429061192c565b801561038f5780601f106103645761010080835404028352916020019161038f565b820191906000526020600020905b81548152906001019060200180831161037257829003601f168201915b5050505050905090565b60009081526065602052604090206001015490565b600060fe826040516103c0919061153a565b9081526040519081900360200190205460ff169050919050565b6103e48282610968565b60008281526097602052604090206103fc908261098c565b505050565b61040b82826109a1565b60008281526097602052604090206103fc90826109e7565b61043d6000805160206119948339815191526102416109fc565b6104625760405162461bcd60e51b8152600401610459906117fb565b60405180910390fd5b61046a610a00565b565b600054610100900460ff1680610485575060005460ff16155b6104a15760405162461bcd60e51b815260040161045990611764565b600054610100900460ff161580156104cc576000805460ff1961ff0019909116610100171660011790555b6104d68383610a6e565b80156103fc576000805461ff0019169055505050565b60c95460ff1690565b61050f6000805160206119948339815191526102416109fc565b61052b5760405162461bcd60e51b8152600401610459906116ef565b61046a610ae8565b600082815260976020526040812061054b9083610b43565b90505b92915050565b60009182526065602090815260408084206001600160a01b0393909316845291905290205460ff1690565b606060fc80546103169061192c565b600081565b61059b6104ec565b156105b85760405162461bcd60e51b81526004016104599061173a565b6105e47f241ecf16d79d0f8dbfb92cbc07fe17840425976cf0667f022fe9877caa831b086102416109fc565b6106005760405162461bcd60e51b8152600401610459906117b2565b60fe82604051610610919061153a565b9081526040519081900360200190205460ff1615610683578060ff600060fd8560405161063d919061153a565b908152602001604051809103902054815260200190815260200160002060006101000a8154816001600160a01b0302191690836001600160a01b03160217905550610738565b6101015460fd83604051610697919061153a565b9081526040805160209281900383019020929092556101018054600090815260ff835283812080546001600160a01b0319166001600160a01b0387161790559054815261010082529190912083516106f19285019061126c565b50600160fe83604051610704919061153a565b908152604051908190036020019020805491151560ff1990921691909117905561010154610733906001611897565b610101555b81604051610746919061153a565b60405180910390207f3c3a120919c3d2626b5616080e13c0cdf4a8576b6ad3029416e3b0e5219e0266826107786109fc565b6040516107869291906115df565b60405180910390a25050565b60008181526097602052604081206102f890610b4f565b600060fe826040516107bb919061153a565b9081526040519081900360200190205460ff16156108175760ff600060fd846040516107e7919061153a565b90815260408051602092819003830190205483529082019290925201600020546001600160a01b031690506102fb565b506000919050565b61040b8282610b5a565b60606000610101548310156108f55760008381526101006020908152604080832060ff9092529091205481546001600160a01b0390911690829061086c9061192c565b80601f01602080910402602001604051908101604052809291908181526020018280546108989061192c565b80156108e55780601f106108ba576101008083540402835291602001916108e5565b820191906000526020600020905b8154815290600101906020018083116108c857829003601f168201915b5050505050915091509150610908565b5050604080516020810190915260008082525b915091565b60008051602061199483398151915281565b7f241ecf16d79d0f8dbfb92cbc07fe17840425976cf0667f022fe9877caa831b0881565b60006001600160e01b03198216637965db0b60e01b14806102f857506102f882610b79565b61097182610399565b6109828161097d6109fc565b610b92565b6103fc8383610bf6565b600061054b836001600160a01b038416610c7d565b6109a96109fc565b6001600160a01b0316816001600160a01b0316146109d95760405162461bcd60e51b815260040161045990611848565b6109e38282610cc7565b5050565b600061054b836001600160a01b038416610d4c565b3390565b610a086104ec565b610a245760405162461bcd60e51b8152600401610459906116c1565b60c9805460ff191690557f5db9ee0a495bf2e6ff9c91a7834c1ba4fdd244a5e8aa4e537bd38aeae4b073aa610a576109fc565b604051610a6491906115cb565b60405180910390a1565b600054610100900460ff1680610a87575060005460ff16155b610aa35760405162461bcd60e51b815260040161045990611764565b600054610100900460ff16158015610ace576000805460ff1961ff0019909116610100171660011790555b610ad6610e63565b610ade610ee2565b6104d68383610f56565b610af06104ec565b15610b0d5760405162461bcd60e51b81526004016104599061173a565b60c9805460ff191660011790557f62e78cea01bee320cd4e420270b5ea74000d11b0c9f74754ebdbfc544b05a258610a576109fc565b600061054b8383611036565b60006102f88261108f565b610b6382610399565b610b6f8161097d6109fc565b6103fc8383610cc7565b6001600160e01b031981166301ffc9a760e01b14919050565b610b9c8282610554565b6109e357610bb4816001600160a01b03166014611093565b610bbf836020611093565b604051602001610bd0929190611556565b60408051601f198184030181529082905262461bcd60e51b82526104599160040161160d565b610c008282610554565b6109e35760008281526065602090815260408083206001600160a01b03851684529091529020805460ff19166001179055610c396109fc565b6001600160a01b0316816001600160a01b0316837f2f8788117e7eff1d82e926ec794901d17c78024a50270940304540a733656f0d60405160405180910390a45050565b6000610c898383611245565b610cbf5750815460018181018455600084815260208082209093018490558454848252828601909352604090209190915561054e565b50600061054e565b610cd18282610554565b156109e35760008281526065602090815260408083206001600160a01b03851684529091529020805460ff19169055610d086109fc565b6001600160a01b0316816001600160a01b0316837ff6391f5c32d9c69d2a47ea670b442974b53935d1edc7fd64eb21e047a839171b60405160405180910390a45050565b60008181526001830160205260408120548015610e59576000610d706001836118ce565b8554909150600090610d84906001906118ce565b90506000866000018281548110610dab57634e487b7160e01b600052603260045260246000fd5b9060005260206000200154905080876000018481548110610ddc57634e487b7160e01b600052603260045260246000fd5b600091825260208083209091019290925582815260018901909152604090208490558654879080610e1d57634e487b7160e01b600052603160045260246000fd5b6001900381819060005260206000200160009055905586600101600087815260200190815260200160002060009055600194505050505061054e565b600091505061054e565b600054610100900460ff1680610e7c575060005460ff16155b610e985760405162461bcd60e51b815260040161045990611764565b600054610100900460ff16158015610ec3576000805460ff1961ff0019909116610100171660011790555b60c9805460ff191690558015610edf576000805461ff00191690555b50565b600054610100900460ff1680610efb575060005460ff16155b610f175760405162461bcd60e51b815260040161045990611764565b600054610100900460ff16158015610f42576000805460ff1961ff0019909116610100171660011790555b8015610edf576000805461ff001916905550565b600054610100900460ff1680610f6f575060005460ff16155b610f8b5760405162461bcd60e51b815260040161045990611764565b600054610100900460ff16158015610fb6576000805460ff1961ff0019909116610100171660011790555b8251610fc99060fb90602086019061126c565b508151610fdd9060fc90602085019061126c565b50610ff06000610feb6109fc565b61125d565b61101c7f241ecf16d79d0f8dbfb92cbc07fe17840425976cf0667f022fe9877caa831b08610feb6109fc565b6104d6600080516020611994833981519152610feb6109fc565b815460009082106110595760405162461bcd60e51b81526004016104599061164a565b82600001828154811061107c57634e487b7160e01b600052603260045260246000fd5b9060005260206000200154905092915050565b5490565b606060006110a28360026118af565b6110ad906002611897565b67ffffffffffffffff8111156110d357634e487b7160e01b600052604160045260246000fd5b6040519080825280601f01601f1916602001820160405280156110fd576020820181803683370190505b509050600360fc1b8160008151811061112657634e487b7160e01b600052603260045260246000fd5b60200101906001600160f81b031916908160001a905350600f60fb1b8160018151811061116357634e487b7160e01b600052603260045260246000fd5b60200101906001600160f81b031916908160001a90535060006111878460026118af565b611192906001611897565b90505b6001811115611226576f181899199a1a9b1b9c1cb0b131b232b360811b85600f16601081106111d457634e487b7160e01b600052603260045260246000fd5b1a60f81b8282815181106111f857634e487b7160e01b600052603260045260246000fd5b60200101906001600160f81b031916908160001a90535060049490941c9361121f81611915565b9050611195565b50831561054b5760405162461bcd60e51b81526004016104599061168c565b60009081526001919091016020526040902054151590565b6103e482826109e38282610bf6565b8280546112789061192c565b90600052602060002090601f01602090048101928261129a57600085556112e0565b82601f106112b357805160ff19168380011785556112e0565b828001600101855582156112e0579182015b828111156112e05782518255916020019190600101906112c5565b506112ec9291506112f0565b5090565b5b808211156112ec57600081556001016112f1565b80356001600160a01b03811681146102fb57600080fd5b600082601f83011261132c578081fd5b813567ffffffffffffffff808211156113475761134761197d565b604051601f8301601f19908116603f0116810190828211818310171561136f5761136f61197d565b81604052838152866020858801011115611387578485fd5b8360208701602083013792830160200193909352509392505050565b6000602082840312156113b4578081fd5b5035919050565b600080604083850312156113cd578081fd5b823591506113dd60208401611305565b90509250929050565b600080604083850312156113f8578182fd5b50508035926020909101359150565b600060208284031215611418578081fd5b81356001600160e01b03198116811461054b578182fd5b600060208284031215611440578081fd5b813567ffffffffffffffff811115611456578182fd5b6114628482850161131c565b949350505050565b6000806040838503121561147c578182fd5b823567ffffffffffffffff811115611492578283fd5b61149e8582860161131c565b9250506113dd60208401611305565b600080604083850312156114bf578182fd5b823567ffffffffffffffff808211156114d6578384fd5b6114e28683870161131c565b935060208501359150808211156114f7578283fd5b506115048582860161131c565b9150509250929050565b600081518084526115268160208601602086016118e5565b601f01601f19169290920160200192915050565b6000825161154c8184602087016118e5565b9190910192915050565b60007f416363657373436f6e74726f6c3a206163636f756e74200000000000000000008252835161158e8160178501602088016118e5565b7001034b99036b4b9b9b4b733903937b6329607d1b60179184019182015283516115bf8160288401602088016118e5565b01602801949350505050565b6001600160a01b0391909116815260200190565b6001600160a01b0392831681529116602082015260400190565b901515815260200190565b90815260200190565b60006020825261054b602083018461150e565b600060408252611633604083018561150e565b905060018060a01b03831660208301529392505050565b60208082526022908201527f456e756d657261626c655365743a20696e646578206f7574206f6620626f756e604082015261647360f01b606082015260800190565b6020808252818101527f537472696e67733a20686578206c656e67746820696e73756666696369656e74604082015260600190565b60208082526014908201527314185d5cd8589b194e881b9bdd081c185d5cd95960621b604082015260600190565b6020808252602b908201527f417373656d626c79444e533a206d75737420686176652070617573657220726f60408201526a6c6520746f20706175736560a81b606082015260800190565b60208082526010908201526f14185d5cd8589b194e881c185d5cd95960821b604082015260600190565b6020808252602e908201527f496e697469616c697a61626c653a20636f6e747261637420697320616c72656160408201526d191e481a5b9a5d1a585b1a5e995960921b606082015260800190565b60208082526029908201527f417373656d626c79444e533a206d75737420686176652070617573657220726f6040820152681b19481d1bc81cd95d60ba1b606082015260800190565b6020808252602d908201527f417373656d626c79444e533a206d75737420686176652070617573657220726f60408201526c6c6520746f20756e706175736560981b606082015260800190565b6020808252602f908201527f416363657373436f6e74726f6c3a2063616e206f6e6c792072656e6f756e636560408201526e103937b632b9903337b91039b2b63360891b606082015260800190565b600082198211156118aa576118aa611967565b500190565b60008160001904831182151516156118c9576118c9611967565b500290565b6000828210156118e0576118e0611967565b500390565b60005b838110156119005781810151838201526020016118e8565b8381111561190f576000848401525b50505050565b60008161192457611924611967565b506000190190565b60028104600182168061194057607f821691505b6020821081141561196157634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052601160045260246000fd5b634e487b7160e01b600052604160045260246000fdfe65d7a28e3265b37a6474929f336521b332c1681b933f6cb9f3376673440d862aa264697066735822122016c6cf7adef5c1efd166f2e7e89b4d45ddb6b2fb1d24f98b4d5ccc7ad8a5ab9b64736f6c63430008010033";

    public static final String FUNC_DEFAULT_ADMIN_ROLE = "DEFAULT_ADMIN_ROLE";

    public static final String FUNC_MANAGER_ROLE = "MANAGER_ROLE";

    public static final String FUNC_PAUSER_ROLE = "PAUSER_ROLE";

    public static final String FUNC_ADDRESSOF = "addressOf";

    public static final String FUNC_COUNT = "count";

    public static final String FUNC_EXISTS = "exists";

    public static final String FUNC_GETROLEADMIN = "getRoleAdmin";

    public static final String FUNC_GETROLEMEMBER = "getRoleMember";

    public static final String FUNC_GETROLEMEMBERCOUNT = "getRoleMemberCount";

    public static final String FUNC_GRANTROLE = "grantRole";

    public static final String FUNC_HASROLE = "hasRole";

    public static final String FUNC_HOSTOF = "hostOf";

    public static final String FUNC_INITIALIZE = "initialize";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_PAUSE = "pause";

    public static final String FUNC_PAUSED = "paused";

    public static final String FUNC_RENOUNCEROLE = "renounceRole";

    public static final String FUNC_REVOKEROLE = "revokeRole";

    public static final String FUNC_SET = "set";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_UNPAUSE = "unpause";

    public static final Event DEL_EVENT = new Event("Del", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>(true) {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event PAUSED_EVENT = new Event("Paused", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event ROLEADMINCHANGED_EVENT = new Event("RoleAdminChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Bytes32>(true) {}, new TypeReference<Bytes32>(true) {}));
    ;

    public static final Event ROLEGRANTED_EVENT = new Event("RoleGranted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event ROLEREVOKED_EVENT = new Event("RoleRevoked", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event SET_EVENT = new Event("Set", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>(true) {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event UNPAUSED_EVENT = new Event("Unpaused", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    @Deprecated
    protected AssemblyDNS(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AssemblyDNS(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AssemblyDNS(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AssemblyDNS(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<DelEventResponse> getDelEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DEL_EVENT, transactionReceipt);
        ArrayList<DelEventResponse> responses = new ArrayList<DelEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DelEventResponse typedResponse = new DelEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.name = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.addr = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.manager = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DelEventResponse> delEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DelEventResponse>() {
            @Override
            public DelEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DEL_EVENT, log);
                DelEventResponse typedResponse = new DelEventResponse();
                typedResponse.log = log;
                typedResponse.name = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.addr = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.manager = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DelEventResponse> delEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DEL_EVENT));
        return delEventFlowable(filter);
    }

    public List<PausedEventResponse> getPausedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PAUSED_EVENT, transactionReceipt);
        ArrayList<PausedEventResponse> responses = new ArrayList<PausedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PausedEventResponse typedResponse = new PausedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PausedEventResponse> pausedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, PausedEventResponse>() {
            @Override
            public PausedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PAUSED_EVENT, log);
                PausedEventResponse typedResponse = new PausedEventResponse();
                typedResponse.log = log;
                typedResponse.account = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PausedEventResponse> pausedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PAUSED_EVENT));
        return pausedEventFlowable(filter);
    }

    public List<RoleAdminChangedEventResponse> getRoleAdminChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ROLEADMINCHANGED_EVENT, transactionReceipt);
        ArrayList<RoleAdminChangedEventResponse> responses = new ArrayList<RoleAdminChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RoleAdminChangedEventResponse typedResponse = new RoleAdminChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.previousAdminRole = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.newAdminRole = (byte[]) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RoleAdminChangedEventResponse> roleAdminChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RoleAdminChangedEventResponse>() {
            @Override
            public RoleAdminChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ROLEADMINCHANGED_EVENT, log);
                RoleAdminChangedEventResponse typedResponse = new RoleAdminChangedEventResponse();
                typedResponse.log = log;
                typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.previousAdminRole = (byte[]) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.newAdminRole = (byte[]) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RoleAdminChangedEventResponse> roleAdminChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ROLEADMINCHANGED_EVENT));
        return roleAdminChangedEventFlowable(filter);
    }

    public List<RoleGrantedEventResponse> getRoleGrantedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ROLEGRANTED_EVENT, transactionReceipt);
        ArrayList<RoleGrantedEventResponse> responses = new ArrayList<RoleGrantedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RoleGrantedEventResponse typedResponse = new RoleGrantedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RoleGrantedEventResponse> roleGrantedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RoleGrantedEventResponse>() {
            @Override
            public RoleGrantedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ROLEGRANTED_EVENT, log);
                RoleGrantedEventResponse typedResponse = new RoleGrantedEventResponse();
                typedResponse.log = log;
                typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RoleGrantedEventResponse> roleGrantedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ROLEGRANTED_EVENT));
        return roleGrantedEventFlowable(filter);
    }

    public List<RoleRevokedEventResponse> getRoleRevokedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ROLEREVOKED_EVENT, transactionReceipt);
        ArrayList<RoleRevokedEventResponse> responses = new ArrayList<RoleRevokedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RoleRevokedEventResponse typedResponse = new RoleRevokedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RoleRevokedEventResponse> roleRevokedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RoleRevokedEventResponse>() {
            @Override
            public RoleRevokedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ROLEREVOKED_EVENT, log);
                RoleRevokedEventResponse typedResponse = new RoleRevokedEventResponse();
                typedResponse.log = log;
                typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RoleRevokedEventResponse> roleRevokedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ROLEREVOKED_EVENT));
        return roleRevokedEventFlowable(filter);
    }

    public List<SetEventResponse> getSetEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SET_EVENT, transactionReceipt);
        ArrayList<SetEventResponse> responses = new ArrayList<SetEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SetEventResponse typedResponse = new SetEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.name = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.addr = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.manager = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SetEventResponse> setEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, SetEventResponse>() {
            @Override
            public SetEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SET_EVENT, log);
                SetEventResponse typedResponse = new SetEventResponse();
                typedResponse.log = log;
                typedResponse.name = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.addr = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.manager = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SetEventResponse> setEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SET_EVENT));
        return setEventFlowable(filter);
    }

    public List<UnpausedEventResponse> getUnpausedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(UNPAUSED_EVENT, transactionReceipt);
        ArrayList<UnpausedEventResponse> responses = new ArrayList<UnpausedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UnpausedEventResponse typedResponse = new UnpausedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<UnpausedEventResponse> unpausedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, UnpausedEventResponse>() {
            @Override
            public UnpausedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(UNPAUSED_EVENT, log);
                UnpausedEventResponse typedResponse = new UnpausedEventResponse();
                typedResponse.log = log;
                typedResponse.account = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<UnpausedEventResponse> unpausedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UNPAUSED_EVENT));
        return unpausedEventFlowable(filter);
    }

    public RemoteFunctionCall<byte[]> DEFAULT_ADMIN_ROLE() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DEFAULT_ADMIN_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> MANAGER_ROLE() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MANAGER_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> PAUSER_ROLE() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PAUSER_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<String> addressOf(String name_) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ADDRESSOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name_)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> count() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_COUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> exists(String name_) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_EXISTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name_)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<byte[]> getRoleAdmin(byte[] role) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETROLEADMIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<String> getRoleMember(byte[] role, BigInteger index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETROLEMEMBER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getRoleMemberCount(byte[] role) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETROLEMEMBERCOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> grantRole(byte[] role, String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_GRANTROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(160, account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> hasRole(byte[] role, String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_HASROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(160, account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Tuple2<String, String>> hostOf(BigInteger index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_HOSTOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
        return new RemoteFunctionCall<Tuple2<String, String>>(function,
                new Callable<Tuple2<String, String>>() {
                    @Override
                    public Tuple2<String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> initialize(String name_, String symbol_) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_INITIALIZE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name_), 
                new org.web3j.abi.datatypes.Utf8String(symbol_)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> name() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> pause() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PAUSE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> paused() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PAUSED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceRole(byte[] role, String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RENOUNCEROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(160, account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> revokeRole(byte[] role, String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REVOKEROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(160, account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> set(String name_, String addr_) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name_), 
                new org.web3j.abi.datatypes.Address(160, addr_)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> supportsInterface(byte[] interfaceId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> symbol() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> unpause() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UNPAUSE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static AssemblyDNS load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AssemblyDNS(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AssemblyDNS load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AssemblyDNS(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AssemblyDNS load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AssemblyDNS(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AssemblyDNS load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AssemblyDNS(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AssemblyDNS> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AssemblyDNS.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AssemblyDNS> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AssemblyDNS.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<AssemblyDNS> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AssemblyDNS.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AssemblyDNS> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AssemblyDNS.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class DelEventResponse extends BaseEventResponse {
        public byte[] name;

        public String addr;

        public String manager;
    }

    public static class PausedEventResponse extends BaseEventResponse {
        public String account;
    }

    public static class RoleAdminChangedEventResponse extends BaseEventResponse {
        public byte[] role;

        public byte[] previousAdminRole;

        public byte[] newAdminRole;
    }

    public static class RoleGrantedEventResponse extends BaseEventResponse {
        public byte[] role;

        public String account;

        public String sender;
    }

    public static class RoleRevokedEventResponse extends BaseEventResponse {
        public byte[] role;

        public String account;

        public String sender;
    }

    public static class SetEventResponse extends BaseEventResponse {
        public byte[] name;

        public String addr;

        public String manager;
    }

    public static class UnpausedEventResponse extends BaseEventResponse {
        public String account;
    }
}
