package com.assembly.sol;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.annotations.NonNull;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.EthChainId;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;




/**
 * Hello world!
 *
 */
import lombok.extern.slf4j.Slf4j;



@Slf4j
public class App {

    public static Web3j web3j;
    public static int chainId = 8801;

    // 钱包文件保持路径，请替换位自己的某文件夹路径
    public static String walletFilePath = "/home/vls/work/assembly-java/wallet";

    // 钱包文件名
    public static String walletFileName = "wallet.json";
    public static String password = "123456";

    public static String walletAddress = "0x4837e39138ef40704d2a97b015828d006e018fd6";

    //kovan 0xD8d2cF6996415dCbA49b270420d8AA195d0dA7C7
    //violin 0xD996c4BD6bd52f1255B50255D184Bb1c1360C982
    public static String contractAddress = "0xA2F2025D4B39Efc3E48706053031b8150C3948dc";
    public static String mnemonic = "type prison hut basket borrow enpower unhappy south local desh salad peace";
    public static String rpc = "http://47.243.254.231/rpc";

    public static Credentials credentials;

    public static AssemblyNotes contract;

    public static void main( String[] args ) throws Exception
    {
        init(args);
        web3j = Web3j.build(new HttpService(rpc));
        //getBlance(walletAddress);
        //creatAccount(password);
        //creatBip39Account(password);
        //creatBip39AccountFromMnemonic(password);
        loadWallet(walletFileName, password); 
        chain_info();
        contractAddress(contractAddress);
        //transto();
        get_logs();
    }

    public static void init(String[] args) throws Exception {
        log.info("args[kovan/violin]: {}", args);
        String chain = "violin";
        if (args.length == 1) {
            chain = args[0];
        }

        if (chain.equals("kovan")) {
            contractAddress = "0xD8d2cF6996415dCbA49b270420d8AA195d0dA7C7";
            rpc = "https://kovan.infura.io/v3/e1ac6790237a4044bff3b676bae7e257";
        } else {
            contractAddress = "0xA2F2025D4B39Efc3E48706053031b8150C3948dc";
            rpc = "http://47.243.254.231/rpc";
        }
        log.info("rpc: {}", rpc);
        log.info("contract address: {}", contractAddress);
    }
    public static void chain_info() throws Exception {
        BigInteger gasPrice = web3j.ethGasPrice().sendAsync().get().getGasPrice();
        String clientVersion = web3j.web3ClientVersion().send().getWeb3ClientVersion();
        log.info("version: {}", web3j.netVersion().send().getNetVersion());
        log.info("client version: {}", clientVersion);
        log.info( "version end!" );

        EthChainId chainId = web3j.ethChainId().send();
        log.info("chainId: {}", chainId.getChainId().longValue());
    }

    public static void getBlance(String walletAddress) throws IOException {
        // 第二个参数：区块的参数，建议选最新区块
        EthGetBalance balance = web3j.ethGetBalance(walletAddress, DefaultBlockParameter.valueOf("latest")).send();
        // 格式转化 wei-ether
        String blanceETH = Convert.fromWei(balance.getBalance().toString(), Convert.Unit.GWEI).toPlainString()
                .concat(" ether");
        log.info("blanceETH:{}", blanceETH);
    }

    // 创建一个钱包，并生成json文件
    public static void creatAccount(String password) throws NoSuchAlgorithmException, NoSuchProviderException,
            InvalidAlgorithmParameterException, CipherException, IOException {
        walletFileName = WalletUtils.generateNewWalletFile(password, new File(walletFilePath), false);
        log.info("walletName: {}", walletFileName);
    }

    // 创建一个钱包，并生成json文件
    public static void creatBip39Account(String password) throws NoSuchAlgorithmException, NoSuchProviderException,
            InvalidAlgorithmParameterException, CipherException, IOException {
        WalletUtils.generateBip39Wallet(password, new File(walletFilePath));
    }

    // 创建一个钱包，并生成json文件
    public static void creatBip39AccountFromMnemonic(String password) throws NoSuchAlgorithmException, NoSuchProviderException,
            InvalidAlgorithmParameterException, CipherException, IOException {
        WalletUtils.generateBip39WalletFromMnemonic("", mnemonic, new File(walletFilePath));
    }
    // 加载钱包文件
    public static void loadWallet(String walletFileName, String passWord) throws IOException, CipherException {
        String walleFilePath = walletFilePath + "/" + walletFileName;
        credentials = WalletUtils.loadCredentials(passWord, walleFilePath);
        String address = credentials.getAddress();
        BigInteger publicKey = credentials.getEcKeyPair().getPublicKey();
        BigInteger privateKey = credentials.getEcKeyPair().getPrivateKey();
        log.info("address=" + address);
        log.info("public key=" + publicKey);
        log.info("private key=" + privateKey);
    }
    // 加载钱包文件
    // 加载合约
    public static void contractAddress(String contractAddress) throws Exception {
        ContractGasProvider contractGasProvider = new DefaultGasProvider();

        //合约初始化
        //需要指定chainId
        //修改 contract = AssemblyNotes.load(contractAddress, web3j, credentials, contractGasProvider);
        //为->
        TransactionManager tm = new RawTransactionManager(web3j, credentials, 8801);
        contract = new AssemblyNotes(contractAddress, web3j, tm, BigInteger.valueOf(2000000000L), BigInteger.valueOf(2100000));

        RemoteFunctionCall<String> contractName = contract.name();
        log.info("contract name: {}", contractName.send());
    }

    // 转账
    public static void transto() throws Exception {
       String address_to = "0x89fF4a850e39A132614dbE517F80603b4A96fa0A"; 

       TransactionManager tm = new RawTransactionManager(web3j, credentials, 8801);//chainId=8801
       Transfer t = new Transfer(web3j, tm);
       TransactionReceipt send = t.sendFunds(address_to,
                BigDecimal.ONE, Convert.Unit.FINNEY, BigInteger.valueOf(20000000000L), BigInteger.valueOf(2100000)).send();
        log.info("Transaction complete:");
        log.info("trans hash=" + send.getTransactionHash());
        log.info("from :" + send.getFrom());
        log.info("to:" + send.getTo());
        log.info("gas used=" + send.getGasUsed());
        log.info("status: " + send.getStatus());
    }
    public static void get_logs() throws Exception {
        String start = "15849210";
        String end= "15849210";
        BigInteger start_block = BigInteger.valueOf(Long.valueOf(start));
        BigInteger end_block = BigInteger.valueOf(Long.valueOf(end));
        Flowable<AssemblyNotes.WriteEventResponse> response = contract.writeEventFlowable(DefaultBlockParameter.valueOf(start_block), DefaultBlockParameter.valueOf(end_block));
        response.subscribe(new Consumer<AssemblyNotes.WriteEventResponse>() {
                @Override
                public void accept(@NonNull AssemblyNotes.WriteEventResponse res) throws Exception {
                    log.info("res" + res.sender);
                }
            });
        log.info("logs: " + response.firstElement());
    }

    public static write() throws Exception {
        sender= "";
        TransactionManager tm = TransactionManager(web3j, sender);
        contract = new AssemblyNotes(contractAddress, web3j, tm, BigInteger.valueOf(2000000000L), BigInteger.valueOf(2100000));

        


    }
}
