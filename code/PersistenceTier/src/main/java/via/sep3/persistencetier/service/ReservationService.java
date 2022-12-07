package via.sep3.persistencetier.service;

import org.lognet.springboot.grpc.GRpcService;
import via.sep3.persistencetier.protobuf.ReservationServiceGrpc;
import via.sep3.persistencetier.protobuf.*;

import javax.transaction.Transactional;

@GRpcService
@Transactional
public class ReservationService extends ReservationServiceGrpc.ReservationServiceImplBase{


}
