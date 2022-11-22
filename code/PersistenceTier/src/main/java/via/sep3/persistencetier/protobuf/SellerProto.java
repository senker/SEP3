// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SellerProto.proto

package via.sep3.persistencetier.protobuf;

public final class SellerProto {
  private SellerProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_seller_SellerRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_seller_SellerRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_seller_UserModelResponseSeller_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_seller_UserModelResponseSeller_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_seller_AddressModelSeller_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_seller_AddressModelSeller_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_seller_CreateUserModelRequestSeller_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_seller_CreateUserModelRequestSeller_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_seller_CreateSellerRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_seller_CreateSellerRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_seller_SellerResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_seller_SellerResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021SellerProto.proto\022\006seller\"\034\n\rSellerReq" +
      "uest\022\013\n\003cvr\030\001 \001(\005\"\234\001\n\027UserModelResponseS" +
      "eller\022\013\n\003cvr\030\001 \001(\005\022\021\n\tfirstName\030\002 \001(\t\022\020\n" +
      "\010lastName\030\003 \001(\t\022+\n\007address\030\004 \001(\0132\032.selle" +
      "r.AddressModelSeller\022\023\n\013phoneNumber\030\005 \001(" +
      "\005\022\r\n\005email\030\006 \001(\t\"H\n\022AddressModelSeller\022\014" +
      "\n\004city\030\001 \001(\t\022\022\n\nstreetName\030\002 \001(\t\022\020\n\010post" +
      "Code\030\003 \001(\005\"\224\001\n\034CreateUserModelRequestSel" +
      "ler\022\021\n\tfirstName\030\002 \001(\t\022\020\n\010lastName\030\003 \001(\t" +
      "\022+\n\007address\030\004 \001(\0132\032.seller.AddressModelS" +
      "eller\022\023\n\013phoneNumber\030\005 \001(\005\022\r\n\005email\030\006 \001(" +
      "\t\"\257\001\n\023CreateSellerRequest\0222\n\004user\030\001 \001(\0132" +
      "$.seller.CreateUserModelRequestSeller\022\013\n" +
      "\003cvr\030\002 \001(\005\022\023\n\013companyName\030\003 \001(\t\022\023\n\013descr" +
      "iption\030\004 \001(\t\022\014\n\004type\030\005 \001(\t\022\017\n\007website\030\006 " +
      "\001(\t\022\016\n\006rating\030\007 \001(\002\"\245\001\n\016SellerResponse\022-" +
      "\n\004user\030\001 \001(\0132\037.seller.UserModelResponseS" +
      "eller\022\013\n\003cvr\030\002 \001(\005\022\023\n\013companyName\030\003 \001(\t\022" +
      "\023\n\013description\030\004 \001(\t\022\014\n\004type\030\005 \001(\t\022\017\n\007we" +
      "bsite\030\006 \001(\t\022\016\n\006rating\030\007 \001(\0022\331\001\n\rSellerSe" +
      "rvice\022C\n\014createSeller\022\033.seller.CreateSel" +
      "lerRequest\032\026.seller.SellerResponse\022?\n\016ge" +
      "tSellerByCvr\022\025.seller.SellerRequest\032\026.se" +
      "ller.SellerResponse\022B\n\021deleteSellerByCvr" +
      "\022\025.seller.SellerRequest\032\026.seller.SellerR" +
      "esponseB%\n!via.sep3.persistencetier.prot" +
      "obufP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_seller_SellerRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_seller_SellerRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_seller_SellerRequest_descriptor,
        new java.lang.String[] { "Cvr", });
    internal_static_seller_UserModelResponseSeller_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_seller_UserModelResponseSeller_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_seller_UserModelResponseSeller_descriptor,
        new java.lang.String[] { "Cvr", "FirstName", "LastName", "Address", "PhoneNumber", "Email", });
    internal_static_seller_AddressModelSeller_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_seller_AddressModelSeller_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_seller_AddressModelSeller_descriptor,
        new java.lang.String[] { "City", "StreetName", "PostCode", });
    internal_static_seller_CreateUserModelRequestSeller_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_seller_CreateUserModelRequestSeller_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_seller_CreateUserModelRequestSeller_descriptor,
        new java.lang.String[] { "FirstName", "LastName", "Address", "PhoneNumber", "Email", });
    internal_static_seller_CreateSellerRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_seller_CreateSellerRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_seller_CreateSellerRequest_descriptor,
        new java.lang.String[] { "User", "Cvr", "CompanyName", "Description", "Type", "Website", "Rating", });
    internal_static_seller_SellerResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_seller_SellerResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_seller_SellerResponse_descriptor,
        new java.lang.String[] { "User", "Cvr", "CompanyName", "Description", "Type", "Website", "Rating", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
