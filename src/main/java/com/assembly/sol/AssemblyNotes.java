package com.assembly.sol;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
public class AssemblyNotes extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50611744806100206000396000f3fe608060405234801561001057600080fd5b50600436106101425760003560e01c80638d82e7e6116100b8578063a217fddf1161007c578063a217fddf1461025e578063ca15c87314610266578063d547741f14610279578063e63ab1e91461028c578063ebaac77114610294578063f8977e96146102a757610142565b80638d82e7e6146102085780639010d07c1461021b57806391d148541461023b57806395d89b411461024e5780639beaab7b1461025657610142565b80632f2ff15d1161010a5780632f2ff15d146101b557806336568abe146101ca5780633f4ba83a146101dd5780634cd88b76146101e55780635c975abb146101f85780638456cb591461020057610142565b806301ffc9a71461014757806306661abd1461017057806306fdde0314610185578063248a9ca31461019a5780632552317c146101ad575b600080fd5b61015a610155366004611222565b6102ba565b604051610167919061139b565b60405180910390f35b6101786102e7565b60405161016791906113a6565b61018d6102f8565b60405161016791906113af565b6101786101a83660046111be565b61038a565b61017861039f565b6101c86101c33660046111d6565b6103a5565b005b6101c86101d83660046111d6565b6103cc565b6101c86103ee565b6101c86101f3366004611285565b610437565b61015a6104b7565b6101c86104c0565b6101786102163660046111a4565b6104fe565b61022e610229366004611201565b610519565b6040516101679190611387565b61015a6102493660046111d6565b61053a565b61018d610565565b610178610574565b610178610598565b6101786102743660046111be565b61059d565b6101c86102873660046111d6565b6105b4565b6101786105be565b6101c86102a236600461124a565b6105d0565b6101786102b53660046111a4565b610719565b60006001600160e01b03198216635a05180f60e01b14806102df57506102df8261073b565b90505b919050565b60006102f360fd610760565b905090565b606060fb805461030790611687565b80601f016020809104026020016040519081016040528092919081815260200182805461033390611687565b80156103805780601f1061035557610100808354040283529160200191610380565b820191906000526020600020905b81548152906001019060200180831161036357829003601f168201915b5050505050905090565b60009081526065602052604090206001015490565b60fe5490565b6103af8282610764565b60008281526097602052604090206103c79082610788565b505050565b6103d6828261079d565b60008281526097602052604090206103c790826107e3565b6104086000805160206116ef8339815191526102496107f8565b61042d5760405162461bcd60e51b8152600401610424906114b4565b60405180910390fd5b6104356107fc565b565b600054610100900460ff1680610450575060005460ff16155b61046c5760405162461bcd60e51b81526004016104249061152d565b600054610100900460ff16158015610497576000805460ff1961ff0019909116610100171660011790555b6104a1838361086a565b80156103c7576000805461ff0019169055505050565b60c95460ff1690565b6104da6000805160206116ef8339815191526102496107f8565b6104f65760405162461bcd60e51b815260040161042490611467565b6104356108e4565b6001600160a01b0316600090815260ff602052604090205490565b6000828152609760205260408120610531908361093f565b90505b92915050565b60009182526065602090815260408084206001600160a01b0393909316845291905290205460ff1690565b606060fc805461030790611687565b7f2b8f168f361ac1393a163ed4adfa899a87be7b7c71645167bdaddd822ae453c881565b600081565b60008181526097602052604081206102df9061094b565b6103d68282610956565b6000805160206116ef83398151915281565b6105d86104b7565b156105f55760405162461bcd60e51b815260040161042490611503565b61062a61010060006106056107f8565b6001600160a01b03166001600160a01b03168152602001908152602001600020610760565b61063460fd610760565b61063c6107f8565b6001600160a01b03167f010cce8a9e62bb2b185ed0b6a9f0b36e03697db6538494e5a56d66150e4b7e2860ff60006106726107f8565b6001600160a01b03166001600160a01b031681526020019081526020016000205442866040516106a4939291906115ca565b60405180910390a46106b660fd610975565b6106eb61010060006106c66107f8565b6001600160a01b03166001600160a01b03168152602001908152602001600020610975565b4360ff60006106f86107f8565b6001600160a01b03168152602081019190915260400160002055504360fe55565b6001600160a01b0381166000908152610100602052604081206102df90610760565b60006001600160e01b03198216637965db0b60e01b14806102df57506102df8261097e565b5490565b61076d8261038a565b61077e816107796107f8565b610997565b6103c783836109fb565b6000610531836001600160a01b038416610a82565b6107a56107f8565b6001600160a01b0316816001600160a01b0316146107d55760405162461bcd60e51b81526004016104249061157b565b6107df8282610acc565b5050565b6000610531836001600160a01b038416610b51565b3390565b6108046104b7565b6108205760405162461bcd60e51b815260040161042490611439565b60c9805460ff191690557f5db9ee0a495bf2e6ff9c91a7834c1ba4fdd244a5e8aa4e537bd38aeae4b073aa6108536107f8565b6040516108609190611387565b60405180910390a1565b600054610100900460ff1680610883575060005460ff16155b61089f5760405162461bcd60e51b81526004016104249061152d565b600054610100900460ff161580156108ca576000805460ff1961ff0019909116610100171660011790555b6108d2610c68565b6108da610ce7565b6104a18383610d5b565b6108ec6104b7565b156109095760405162461bcd60e51b815260040161042490611503565b60c9805460ff191660011790557f62e78cea01bee320cd4e420270b5ea74000d11b0c9f74754ebdbfc544b05a2586108536107f8565b60006105318383610e3b565b60006102df82610760565b61095f8261038a565b61096b816107796107f8565b6103c78383610acc565b80546001019055565b6001600160e01b031981166301ffc9a760e01b14919050565b6109a1828261053a565b6107df576109b9816001600160a01b03166014610e94565b6109c4836020610e94565b6040516020016109d5929190611312565b60408051601f198184030181529082905262461bcd60e51b8252610424916004016113af565b610a05828261053a565b6107df5760008281526065602090815260408083206001600160a01b03851684529091529020805460ff19166001179055610a3e6107f8565b6001600160a01b0316816001600160a01b0316837f2f8788117e7eff1d82e926ec794901d17c78024a50270940304540a733656f0d60405160405180910390a45050565b6000610a8e8383611046565b610ac457508154600181810184556000848152602080822090930184905584548482528286019093526040902091909155610534565b506000610534565b610ad6828261053a565b156107df5760008281526065602090815260408083206001600160a01b03851684529091529020805460ff19169055610b0d6107f8565b6001600160a01b0316816001600160a01b0316837ff6391f5c32d9c69d2a47ea670b442974b53935d1edc7fd64eb21e047a839171b60405160405180910390a45050565b60008181526001830160205260408120548015610c5e576000610b75600183611629565b8554909150600090610b8990600190611629565b90506000866000018281548110610bb057634e487b7160e01b600052603260045260246000fd5b9060005260206000200154905080876000018481548110610be157634e487b7160e01b600052603260045260246000fd5b600091825260208083209091019290925582815260018901909152604090208490558654879080610c2257634e487b7160e01b600052603160045260246000fd5b60019003818190600052602060002001600090559055866001016000878152602001908152602001600020600090556001945050505050610534565b6000915050610534565b600054610100900460ff1680610c81575060005460ff16155b610c9d5760405162461bcd60e51b81526004016104249061152d565b600054610100900460ff16158015610cc8576000805460ff1961ff0019909116610100171660011790555b60c9805460ff191690558015610ce4576000805461ff00191690555b50565b600054610100900460ff1680610d00575060005460ff16155b610d1c5760405162461bcd60e51b81526004016104249061152d565b600054610100900460ff16158015610d47576000805460ff1961ff0019909116610100171660011790555b8015610ce4576000805461ff001916905550565b600054610100900460ff1680610d74575060005460ff16155b610d905760405162461bcd60e51b81526004016104249061152d565b600054610100900460ff16158015610dbb576000805460ff1961ff0019909116610100171660011790555b8251610dce9060fb90602086019061106d565b508151610de29060fc90602085019061106d565b50610df56000610df06107f8565b61105e565b610e217f2b8f168f361ac1393a163ed4adfa899a87be7b7c71645167bdaddd822ae453c8610df06107f8565b6104a16000805160206116ef833981519152610df06107f8565b81546000908210610e5e5760405162461bcd60e51b8152600401610424906113c2565b826000018281548110610e8157634e487b7160e01b600052603260045260246000fd5b9060005260206000200154905092915050565b60606000610ea383600261160a565b610eae9060026115f2565b67ffffffffffffffff811115610ed457634e487b7160e01b600052604160045260246000fd5b6040519080825280601f01601f191660200182016040528015610efe576020820181803683370190505b509050600360fc1b81600081518110610f2757634e487b7160e01b600052603260045260246000fd5b60200101906001600160f81b031916908160001a905350600f60fb1b81600181518110610f6457634e487b7160e01b600052603260045260246000fd5b60200101906001600160f81b031916908160001a9053506000610f8884600261160a565b610f939060016115f2565b90505b6001811115611027576f181899199a1a9b1b9c1cb0b131b232b360811b85600f1660108110610fd557634e487b7160e01b600052603260045260246000fd5b1a60f81b828281518110610ff957634e487b7160e01b600052603260045260246000fd5b60200101906001600160f81b031916908160001a90535060049490941c9361102081611670565b9050610f96565b5083156105315760405162461bcd60e51b815260040161042490611404565b60009081526001919091016020526040902054151590565b6103af82826107df82826109fb565b82805461107990611687565b90600052602060002090601f01602090048101928261109b57600085556110e1565b82601f106110b457805160ff19168380011785556110e1565b828001600101855582156110e1579182015b828111156110e15782518255916020019190600101906110c6565b506110ed9291506110f1565b5090565b5b808211156110ed57600081556001016110f2565b80356001600160a01b03811681146102e257600080fd5b600082601f83011261112d578081fd5b813567ffffffffffffffff80821115611148576111486116d8565b604051601f8301601f19908116603f01168101908282118183101715611170576111706116d8565b81604052838152866020858801011115611188578485fd5b8360208701602083013792830160200193909352509392505050565b6000602082840312156111b5578081fd5b61053182611106565b6000602082840312156111cf578081fd5b5035919050565b600080604083850312156111e8578081fd5b823591506111f860208401611106565b90509250929050565b60008060408385031215611213578182fd5b50508035926020909101359150565b600060208284031215611233578081fd5b81356001600160e01b031981168114610531578182fd5b60006020828403121561125b578081fd5b813567ffffffffffffffff811115611271578182fd5b61127d8482850161111d565b949350505050565b60008060408385031215611297578182fd5b823567ffffffffffffffff808211156112ae578384fd5b6112ba8683870161111d565b935060208501359150808211156112cf578283fd5b506112dc8582860161111d565b9150509250929050565b600081518084526112fe816020860160208601611640565b601f01601f19169290920160200192915050565b60007f416363657373436f6e74726f6c3a206163636f756e74200000000000000000008252835161134a816017850160208801611640565b7001034b99036b4b9b9b4b733903937b6329607d1b601791840191820152835161137b816028840160208801611640565b01602801949350505050565b6001600160a01b0391909116815260200190565b901515815260200190565b90815260200190565b60006020825261053160208301846112e6565b60208082526022908201527f456e756d657261626c655365743a20696e646578206f7574206f6620626f756e604082015261647360f01b606082015260800190565b6020808252818101527f537472696e67733a20686578206c656e67746820696e73756666696369656e74604082015260600190565b60208082526014908201527314185d5cd8589b194e881b9bdd081c185d5cd95960621b604082015260600190565b6020808252602d908201527f417373656d626c794e6f7465733a206d7573742068617665207061757365722060408201526c726f6c6520746f20706175736560981b606082015260800190565b6020808252602f908201527f417373656d626c794e6f7465733a206d7573742068617665207061757365722060408201526e726f6c6520746f20756e706175736560881b606082015260800190565b60208082526010908201526f14185d5cd8589b194e881c185d5cd95960821b604082015260600190565b6020808252602e908201527f496e697469616c697a61626c653a20636f6e747261637420697320616c72656160408201526d191e481a5b9a5d1a585b1a5e995960921b606082015260800190565b6020808252602f908201527f416363657373436f6e74726f6c3a2063616e206f6e6c792072656e6f756e636560408201526e103937b632b9903337b91039b2b63360891b606082015260800190565b6000848252836020830152606060408301526115e960608301846112e6565b95945050505050565b60008219821115611605576116056116c2565b500190565b6000816000190483118215151615611624576116246116c2565b500290565b60008282101561163b5761163b6116c2565b500390565b60005b8381101561165b578181015183820152602001611643565b8381111561166a576000848401525b50505050565b60008161167f5761167f6116c2565b506000190190565b60028104600182168061169b57607f821691505b602082108114156116bc57634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052601160045260246000fd5b634e487b7160e01b600052604160045260246000fdfe65d7a28e3265b37a6474929f336521b332c1681b933f6cb9f3376673440d862aa2646970667358221220eb97745839db24e00e00407817bd4d96d4eb99b4f259d1744409be4c881fd99864736f6c63430008010033";

    public static final String FUNC_DEFAULT_ADMIN_ROLE = "DEFAULT_ADMIN_ROLE";

    public static final String FUNC_PAUSER_ROLE = "PAUSER_ROLE";

    public static final String FUNC_WRITER_ROLE = "WRITER_ROLE";

    public static final String FUNC_COUNT = "count";

    public static final String FUNC_COUNTOF = "countOf";

    public static final String FUNC_GETROLEADMIN = "getRoleAdmin";

    public static final String FUNC_GETROLEMEMBER = "getRoleMember";

    public static final String FUNC_GETROLEMEMBERCOUNT = "getRoleMemberCount";

    public static final String FUNC_GRANTROLE = "grantRole";

    public static final String FUNC_HASROLE = "hasRole";

    public static final String FUNC_INITIALIZE = "initialize";

    public static final String FUNC_LASTBLOCKNUMBER = "lastBlockNumber";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_PAUSE = "pause";

    public static final String FUNC_PAUSED = "paused";

    public static final String FUNC_PREBLOCKNUMBEROF = "preBlockNumberOf";

    public static final String FUNC_RENOUNCEROLE = "renounceRole";

    public static final String FUNC_REVOKEROLE = "revokeRole";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_UNPAUSE = "unpause";

    public static final String FUNC_WRITE = "write";

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

    public static final Event UNPAUSED_EVENT = new Event("Unpaused", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event WRITE_EVENT = new Event("Write", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
    ;

    @Deprecated
    protected AssemblyNotes(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AssemblyNotes(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AssemblyNotes(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AssemblyNotes(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
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

    public List<WriteEventResponse> getWriteEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WRITE_EVENT, transactionReceipt);
        ArrayList<WriteEventResponse> responses = new ArrayList<WriteEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WriteEventResponse typedResponse = new WriteEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.index = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.senderIndex = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.preBlockNumber = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.data = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<WriteEventResponse> writeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, WriteEventResponse>() {
            @Override
            public WriteEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WRITE_EVENT, log);
                WriteEventResponse typedResponse = new WriteEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.index = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.senderIndex = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.preBlockNumber = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.data = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<WriteEventResponse> writeEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WRITE_EVENT));
        return writeEventFlowable(filter);
    }

    public RemoteFunctionCall<byte[]> DEFAULT_ADMIN_ROLE() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DEFAULT_ADMIN_ROLE, 
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

    public RemoteFunctionCall<byte[]> WRITER_ROLE() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_WRITER_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> count() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_COUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> countOf(String writer) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_COUNTOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, writer)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteFunctionCall<TransactionReceipt> initialize(String name_, String symbol_) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_INITIALIZE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name_), 
                new org.web3j.abi.datatypes.Utf8String(symbol_)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> lastBlockNumber() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LASTBLOCKNUMBER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteFunctionCall<BigInteger> preBlockNumberOf(String writer) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PREBLOCKNUMBEROF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, writer)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteFunctionCall<TransactionReceipt> write(String data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_WRITE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static AssemblyNotes load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AssemblyNotes(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AssemblyNotes load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AssemblyNotes(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AssemblyNotes load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AssemblyNotes(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AssemblyNotes load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AssemblyNotes(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AssemblyNotes> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AssemblyNotes.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AssemblyNotes> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AssemblyNotes.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<AssemblyNotes> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AssemblyNotes.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AssemblyNotes> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AssemblyNotes.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
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

    public static class UnpausedEventResponse extends BaseEventResponse {
        public String account;
    }

    public static class WriteEventResponse extends BaseEventResponse {
        public String sender;

        public BigInteger index;

        public BigInteger senderIndex;

        public BigInteger preBlockNumber;

        public BigInteger timestamp;

        public String data;
    }
}
