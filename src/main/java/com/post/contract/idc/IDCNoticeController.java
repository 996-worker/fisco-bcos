package com.post.contract.idc;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.fisco.bcos.sdk.abi.FunctionReturnDecoder;
import org.fisco.bcos.sdk.abi.TypeReference;
import org.fisco.bcos.sdk.abi.datatypes.Address;
import org.fisco.bcos.sdk.abi.datatypes.Bool;
import org.fisco.bcos.sdk.abi.datatypes.Event;
import org.fisco.bcos.sdk.abi.datatypes.Function;
import org.fisco.bcos.sdk.abi.datatypes.Type;
import org.fisco.bcos.sdk.abi.datatypes.Utf8String;
import org.fisco.bcos.sdk.abi.datatypes.generated.Bytes32;
import org.fisco.bcos.sdk.abi.datatypes.generated.Uint256;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple1;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple4;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.contract.Contract;
import org.fisco.bcos.sdk.crypto.CryptoSuite;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.eventsub.EventCallback;
import org.fisco.bcos.sdk.model.CryptoType;
import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.fisco.bcos.sdk.model.callback.TransactionCallback;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;

@SuppressWarnings("unchecked")
public class IDCNoticeController extends Contract {
    public static final String[] BINARY_ARRAY = {"6080604052336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550610e0e806100536000396000f300608060405260043610610078576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680639c52a7f11461007d578063c0c5a39d146100c0578063c2bc2efc1461014b578063e30e17c5146101a6578063ef74f27d14610250578063ff9913e814610281575b600080fd5b34801561008957600080fd5b506100be600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506102c4565b005b3480156100cc57600080fd5b5061014960048036038101908080356000191690602001909291908035906020019092919080359060200190929190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506103e3565b005b34801561015757600080fd5b5061018c600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506104ac565b604051808215151515815260200191505060405180910390f35b3480156101b257600080fd5b506101d560048036038101908080356000191690602001909291905050506105c6565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156102155780820151818401526020810190506101fa565b50505050905090810190601f1680156102425780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561025c57600080fd5b5061027f60048036038101908080356000191690602001909291905050506105d8565b005b34801561028d57600080fd5b506102c2600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610666565b005b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610388576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260098152602001807f6e6f742061646d696e000000000000000000000000000000000000000000000081525060200191505060405180910390fd5b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b836000600102816000191614151515610464576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260128152602001807f4e6f742076616c6964207365726965734e6f000000000000000000000000000081525060200191505060405180910390fd5b84600019167f0acc86875b2ea24bebeb881926cc83ebc23cc350014c536f914ab5a341f157cb60405160405180910390a26104a58533428787876001610815565b5050505050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610572576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260098152602001807f6e6f742061646d696e000000000000000000000000000000000000000000000081525060200191505060405180910390fd5b600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff169050919050565b60606105d182610a94565b9050919050565b806000600102816000191614151515610659576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260128152602001807f4e6f742076616c6964207365726965734e6f000000000000000000000000000081525060200191505060405180910390fd5b61066282610bdd565b5050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561072a576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260098152602001807f6e6f742061646d696e000000000000000000000000000000000000000000000081525060200191505060405180910390fd5b8060008173ffffffffffffffffffffffffffffffffffffffff16141515156107ba576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252600f8152602001807f6e6f7420616c6c6f7720656d707479000000000000000000000000000000000081525060200191505060405180910390fd5b60018060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614806108c0575060011515600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff161515145b1515610934576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260118152602001807f6e6f742061757468656e7469636174656400000000000000000000000000000081525060200191505060405180910390fd5b8660026000896000191660001916815260200190815260200160002060000181600019169055508560026000896000191660001916815260200190815260200160002060010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550846002600089600019166000191681526020019081526020016000206005018190555083600260008960001916600019168152602001908152602001600020600201819055508260026000896000191660001916815260200190815260200160002060030181905550816002600089600019166000191681526020019081526020016000206004019080519060200190610a53929190610d3d565b508060026000896000191660001916815260200190815260200160002060060160006101000a81548160ff021916908360ff16021790555050505050505050565b6060600060026000846000191660001916815260200190815260200160002090508260001916816000015460001916141515610b38576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260178152602001807f4944434e6f7469636544617461206e6f7420657869737400000000000000000081525060200191505060405180910390fd5b806004018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610bd05780601f10610ba557610100808354040283529160200191610bd0565b820191906000526020600020905b815481529060010190602001808311610bb357829003601f168201915b5050505050915050919050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161480610c8a575060011515600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff161515145b1515610cfe576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260118152602001807f6e6f742061757468656e7469636174656400000000000000000000000000000081525060200191505060405180910390fd5b600260008360001916600019168152602001908152602001600020905060008160060160006101000a81548160ff021916908360ff1602179055505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610d7e57805160ff1916838001178555610dac565b82800160010185558215610dac579182015b82811115610dab578251825591602001919060010190610d90565b5b509050610db99190610dbd565b5090565b610ddf91905b80821115610ddb576000816000905550600101610dc3565b5090565b905600a165627a7a72305820271bd65696977d1051475c1ac5d2c53583968a5a1b648d31f97f9a9939fa777e0029"};

    public static final String BINARY = org.fisco.bcos.sdk.utils.StringUtils.joinAll("", BINARY_ARRAY);

    public static final String[] SM_BINARY_ARRAY = {"6080604052336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550610e0e806100536000396000f300608060405260043610610078576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063195b2d431461007d57806356bea000146101085780638b0bb8c01461014b578063da89dd381461017c578063e6bf5f92146101bf578063f7feb7c71461021a575b600080fd5b34801561008957600080fd5b5061010660048036038101908080356000191690602001909291908035906020019092919080359060200190929190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506102c4565b005b34801561011457600080fd5b50610149600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061038d565b005b34801561015757600080fd5b5061017a60048036038101908080356000191690602001909291905050506104ac565b005b34801561018857600080fd5b506101bd600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061053a565b005b3480156101cb57600080fd5b50610200600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506106e9565b604051808215151515815260200191505060405180910390f35b34801561022657600080fd5b506102496004803603810190808035600019169060200190929190505050610803565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561028957808201518184015260208101905061026e565b50505050905090810190601f1680156102b65780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b836000600102816000191614151515610345576040517fc703cb120000000000000000000000000000000000000000000000000000000081526004018080602001828103825260128152602001807f4e6f742076616c6964207365726965734e6f000000000000000000000000000081525060200191505060405180910390fd5b84600019167fd5cb212e56860e32b73e0686c166f28880ca0922c8afb775cdf6ebea6c10fdd760405160405180910390a26103868533428787876001610815565b5050505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610451576040517fc703cb120000000000000000000000000000000000000000000000000000000081526004018080602001828103825260098152602001807f6e6f742061646d696e000000000000000000000000000000000000000000000081525060200191505060405180910390fd5b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b80600060010281600019161415151561052d576040517fc703cb120000000000000000000000000000000000000000000000000000000081526004018080602001828103825260128152602001807f4e6f742076616c6964207365726965734e6f000000000000000000000000000081525060200191505060405180910390fd5b61053682610a94565b5050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156105fe576040517fc703cb120000000000000000000000000000000000000000000000000000000081526004018080602001828103825260098152602001807f6e6f742061646d696e000000000000000000000000000000000000000000000081525060200191505060405180910390fd5b8060008173ffffffffffffffffffffffffffffffffffffffff161415151561068e576040517fc703cb1200000000000000000000000000000000000000000000000000000000815260040180806020018281038252600f8152602001807f6e6f7420616c6c6f7720656d707479000000000000000000000000000000000081525060200191505060405180910390fd5b60018060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055505050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156107af576040517fc703cb120000000000000000000000000000000000000000000000000000000081526004018080602001828103825260098152602001807f6e6f742061646d696e000000000000000000000000000000000000000000000081525060200191505060405180910390fd5b600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff169050919050565b606061080e82610bf4565b9050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614806108c0575060011515600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff161515145b1515610934576040517fc703cb120000000000000000000000000000000000000000000000000000000081526004018080602001828103825260118152602001807f6e6f742061757468656e7469636174656400000000000000000000000000000081525060200191505060405180910390fd5b8660026000896000191660001916815260200190815260200160002060000181600019169055508560026000896000191660001916815260200190815260200160002060010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550846002600089600019166000191681526020019081526020016000206005018190555083600260008960001916600019168152602001908152602001600020600201819055508260026000896000191660001916815260200190815260200160002060030181905550816002600089600019166000191681526020019081526020016000206004019080519060200190610a53929190610d3d565b508060026000896000191660001916815260200190815260200160002060060160006101000a81548160ff021916908360ff16021790555050505050505050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161480610b41575060011515600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff161515145b1515610bb5576040517fc703cb120000000000000000000000000000000000000000000000000000000081526004018080602001828103825260118152602001807f6e6f742061757468656e7469636174656400000000000000000000000000000081525060200191505060405180910390fd5b600260008360001916600019168152602001908152602001600020905060008160060160006101000a81548160ff021916908360ff1602179055505050565b6060600060026000846000191660001916815260200190815260200160002090508260001916816000015460001916141515610c98576040517fc703cb120000000000000000000000000000000000000000000000000000000081526004018080602001828103825260178152602001807f4944434e6f7469636544617461206e6f7420657869737400000000000000000081525060200191505060405180910390fd5b806004018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610d305780601f10610d0557610100808354040283529160200191610d30565b820191906000526020600020905b815481529060010190602001808311610d1357829003601f168201915b5050505050915050919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610d7e57805160ff1916838001178555610dac565b82800160010185558215610dac579182015b82811115610dab578251825591602001919060010190610d90565b5b509050610db99190610dbd565b5090565b610ddf91905b80821115610ddb576000816000905550600101610dc3565b5090565b905600a165627a7a7230582044ff55c498cca5945dd89f8362dbe190bc54eb52b59c94abf7e75f73c09f8a170029"};

    public static final String SM_BINARY = org.fisco.bcos.sdk.utils.StringUtils.joinAll("", SM_BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":false,\"inputs\":[{\"name\":\"addr\",\"type\":\"address\"}],\"name\":\"deny\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"seriesNo\",\"type\":\"bytes32\"},{\"name\":\"plannedStartTime\",\"type\":\"uint256\"},{\"name\":\"plannedEndTime\",\"type\":\"uint256\"},{\"name\":\"contentJson\",\"type\":\"string\"}],\"name\":\"createIDCNotice\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"addr\",\"type\":\"address\"}],\"name\":\"get\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"seriesNo\",\"type\":\"bytes32\"}],\"name\":\"geIDCNotice\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"seriesNo\",\"type\":\"bytes32\"}],\"name\":\"delIDCNotice\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"addr\",\"type\":\"address\"}],\"name\":\"allow\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":true,\"name\":\"seriesNo\",\"type\":\"bytes32\"}],\"name\":\"IDCNoticeSaved\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":true,\"name\":\"seriesNo\",\"type\":\"bytes32\"}],\"name\":\"WithDrawLog\",\"type\":\"event\"}]"};

    public static final String ABI = org.fisco.bcos.sdk.utils.StringUtils.joinAll("", ABI_ARRAY);

    public static final String FUNC_DENY = "deny";

    public static final String FUNC_CREATEIDCNOTICE = "createIDCNotice";

    public static final String FUNC_GET = "get";

    public static final String FUNC_GEIDCNOTICE = "geIDCNotice";

    public static final String FUNC_DELIDCNOTICE = "delIDCNotice";

    public static final String FUNC_ALLOW = "allow";

	public static final Event IDCNOTICESAVED_EVENT = new Event("IDCNoticeSaved", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}));
    ;

    public static final Event WITHDRAWLOG_EVENT = new Event("WithDrawLog", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}));
    ;

    protected IDCNoticeController(String contractAddress, Client client, CryptoKeyPair credential) {
        super(getBinary(client.getCryptoSuite()), contractAddress, client, credential);
    }

    public static String getBinary(CryptoSuite cryptoSuite) {
        return (cryptoSuite.getCryptoTypeConfig() == CryptoType.ECDSA_TYPE ? BINARY : SM_BINARY);
    }

    public TransactionReceipt deny(String addr) {
        final Function function = new Function(
                FUNC_DENY, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Address(addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public byte[] deny(String addr, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_DENY, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Address(addr)), 
                Collections.<TypeReference<?>>emptyList());
        return asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForDeny(String addr) {
        final Function function = new Function(
                FUNC_DENY, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Address(addr)), 
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple1<String> getDenyInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_DENY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public TransactionReceipt createIDCNotice(byte[] seriesNo, BigInteger plannedStartTime, BigInteger plannedEndTime, String contentJson) {
        final Function function = new Function(
                FUNC_CREATEIDCNOTICE, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Bytes32(seriesNo), 
                new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(plannedStartTime), 
                new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(plannedEndTime), 
                new org.fisco.bcos.sdk.abi.datatypes.Utf8String(contentJson)), 
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public byte[] createIDCNotice(byte[] seriesNo, BigInteger plannedStartTime, BigInteger plannedEndTime, String contentJson, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_CREATEIDCNOTICE, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Bytes32(seriesNo), 
                new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(plannedStartTime), 
                new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(plannedEndTime), 
                new org.fisco.bcos.sdk.abi.datatypes.Utf8String(contentJson)), 
                Collections.<TypeReference<?>>emptyList());
        return asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForCreateIDCNotice(byte[] seriesNo, BigInteger plannedStartTime, BigInteger plannedEndTime, String contentJson) {
        final Function function = new Function(
                FUNC_CREATEIDCNOTICE, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Bytes32(seriesNo), 
                new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(plannedStartTime), 
                new org.fisco.bcos.sdk.abi.datatypes.generated.Uint256(plannedEndTime), 
                new org.fisco.bcos.sdk.abi.datatypes.Utf8String(contentJson)), 
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple4<byte[], BigInteger, BigInteger, String> getCreateIDCNoticeInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_CREATEIDCNOTICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple4<byte[], BigInteger, BigInteger, String>(

                (byte[]) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue(), 
                (BigInteger) results.get(2).getValue(), 
                (String) results.get(3).getValue()
                );
    }

    public Boolean get(String addr) throws ContractException {
        final Function function = new Function(FUNC_GET, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Address(addr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallWithSingleValueReturn(function, Boolean.class);
    }

    public String geIDCNotice(byte[] seriesNo) throws ContractException {
        final Function function = new Function(FUNC_GEIDCNOTICE, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Bytes32(seriesNo)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallWithSingleValueReturn(function, String.class);
    }

    public TransactionReceipt delIDCNotice(byte[] seriesNo) {
        final Function function = new Function(
                FUNC_DELIDCNOTICE, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Bytes32(seriesNo)), 
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public byte[] delIDCNotice(byte[] seriesNo, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_DELIDCNOTICE, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Bytes32(seriesNo)), 
                Collections.<TypeReference<?>>emptyList());
        return asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForDelIDCNotice(byte[] seriesNo) {
        final Function function = new Function(
                FUNC_DELIDCNOTICE, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.generated.Bytes32(seriesNo)), 
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple1<byte[]> getDelIDCNoticeInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_DELIDCNOTICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple1<byte[]>(

                (byte[]) results.get(0).getValue()
                );
    }

    public TransactionReceipt allow(String addr) {
        final Function function = new Function(
                FUNC_ALLOW, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Address(addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public byte[] allow(String addr, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_ALLOW, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Address(addr)), 
                Collections.<TypeReference<?>>emptyList());
        return asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForAllow(String addr) {
        final Function function = new Function(
                FUNC_ALLOW, 
                Arrays.<Type>asList(new org.fisco.bcos.sdk.abi.datatypes.Address(addr)), 
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple1<String> getAllowInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_ALLOW, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public List<IDCNoticeSavedEventResponse> getIDCNoticeSavedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(IDCNOTICESAVED_EVENT, transactionReceipt);
        ArrayList<IDCNoticeSavedEventResponse> responses = new ArrayList<IDCNoticeSavedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            IDCNoticeSavedEventResponse typedResponse = new IDCNoticeSavedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.seriesNo = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void subscribeIDCNoticeSavedEvent(String fromBlock, String toBlock, List<String> otherTopics, EventCallback callback) {
        String topic0 = eventEncoder.encode(IDCNOTICESAVED_EVENT);
        subscribeEvent(ABI,BINARY,topic0,fromBlock,toBlock,otherTopics,callback);
    }

    public void subscribeIDCNoticeSavedEvent(EventCallback callback) {
        String topic0 = eventEncoder.encode(IDCNOTICESAVED_EVENT);
        subscribeEvent(ABI,BINARY,topic0,callback);
    }

    public List<WithDrawLogEventResponse> getWithDrawLogEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WITHDRAWLOG_EVENT, transactionReceipt);
        ArrayList<WithDrawLogEventResponse> responses = new ArrayList<WithDrawLogEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WithDrawLogEventResponse typedResponse = new WithDrawLogEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.seriesNo = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void subscribeWithDrawLogEvent(String fromBlock, String toBlock, List<String> otherTopics, EventCallback callback) {
        String topic0 = eventEncoder.encode(WITHDRAWLOG_EVENT);
        subscribeEvent(ABI,BINARY,topic0,fromBlock,toBlock,otherTopics,callback);
    }

    public void subscribeWithDrawLogEvent(EventCallback callback) {
        String topic0 = eventEncoder.encode(WITHDRAWLOG_EVENT);
        subscribeEvent(ABI,BINARY,topic0,callback);
    }

    public static IDCNoticeController load(String contractAddress, Client client, CryptoKeyPair credential) {
        return new IDCNoticeController(contractAddress, client, credential);
    }

    public static IDCNoticeController deploy(Client client, CryptoKeyPair credential) throws ContractException {
        return deploy(IDCNoticeController.class, client, credential, getBinary(client.getCryptoSuite()), "");
    }

    public static class IDCNoticeSavedEventResponse {
        public TransactionReceipt.Logs log;

        public byte[] seriesNo;
    }

    public static class WithDrawLogEventResponse {
        public TransactionReceipt.Logs log;

        public byte[] seriesNo;
    }
}
