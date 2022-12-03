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
    internal_static_seller_EmptySeller_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_seller_EmptySeller_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_seller_SellerRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_seller_SellerRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_seller_ImageModelRequestSeller_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_seller_ImageModelRequestSeller_fieldAccessorTable;
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
      "\n\021SellerProto.proto\022\006seller\"\r\n\013EmptySell" +
      "er\"\034\n\rSellerRequest\022\013\n\003cvr\030\001 \001(\005\"+\n\027Imag" +
      "eModelRequestSeller\022\020\n\010imageUrl\030\001 \001(\t\"\217\001" +
      "\n\027UserModelResponseSeller\022\021\n\tfirstName\030\001" +
      " \001(\t\022\020\n\010lastName\030\002 \001(\t\022+\n\007address\030\003 \001(\0132" +
      "\032.seller.AddressModelSeller\022\023\n\013phoneNumb" +
      "er\030\004 \001(\005\022\r\n\005email\030\005 \001(\t\"H\n\022AddressModelS" +
      "eller\022\014\n\004city\030\001 \001(\t\022\022\n\nstreetName\030\002 \001(\t\022" +
      "\020\n\010postCode\030\003 \001(\005\"\246\001\n\034CreateUserModelReq" +
      "uestSeller\022\021\n\tfirstName\030\001 \001(\t\022\020\n\010lastNam" +
      "e\030\002 \001(\t\022+\n\007address\030\003 \001(\0132\032.seller.Addres" +
      "sModelSeller\022\023\n\013phoneNumber\030\004 \001(\005\022\r\n\005ema" +
      "il\030\005 \001(\t\022\020\n\010password\030\006 \001(\t\"\337\001\n\023CreateSel" +
      "lerRequest\0222\n\004user\030\001 \001(\0132$.seller.Create" +
      "UserModelRequestSeller\022\013\n\003cvr\030\002 \001(\005\022\023\n\013c" +
      "ompanyName\030\003 \001(\t\022\023\n\013description\030\004 \001(\t\022\014\n" +
      "\004type\030\005 \001(\t\022\017\n\007website\030\006 \001(\t\022\016\n\006rating\030\007" +
      " \001(\002\022.\n\005image\030\010 \001(\0132\037.seller.ImageModelR" +
      "equestSeller\"\325\001\n\016SellerResponse\022-\n\004user\030" +
      "\001 \001(\0132\037.seller.UserModelResponseSeller\022\013" +
      "\n\003cvr\030\002 \001(\005\022\023\n\013companyName\030\003 \001(\t\022\023\n\013desc" +
      "ription\030\004 \001(\t\022\014\n\004type\030\005 \001(\t\022\017\n\007website\030\006" +
      " \001(\t\022\016\n\006rating\030\007 \001(\002\022.\n\005image\030\010 \001(\0132\037.se" +
      "ller.ImageModelRequestSeller2\231\002\n\rSellerS" +
      "ervice\022C\n\014createSeller\022\033.seller.CreateSe" +
      "llerRequest\032\026.seller.SellerResponse\022?\n\016g" +
      "etSellerByCvr\022\025.seller.SellerRequest\032\026.s" +
      "eller.SellerResponse\022>\n\rgetAllSellers\022\023." +
      "seller.EmptySeller\032\026.seller.SellerRespon" +
      "se0\001\022B\n\021deleteSellerByCvr\022\025.seller.Selle" +
      "rRequest\032\026.seller.SellerResponseB%\n!via." +
      "sep3.persistencetier.protobufP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_seller_EmptySeller_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_seller_EmptySeller_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_seller_EmptySeller_descriptor,
        new java.lang.String[] { });
    internal_static_seller_SellerRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_seller_SellerRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_seller_SellerRequest_descriptor,
        new java.lang.String[] { "Cvr", });
    internal_static_seller_ImageModelRequestSeller_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_seller_ImageModelRequestSeller_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_seller_ImageModelRequestSeller_descriptor,
        new java.lang.String[] { "ImageUrl", });
    internal_static_seller_UserModelResponseSeller_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_seller_UserModelResponseSeller_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_seller_UserModelResponseSeller_descriptor,
        new java.lang.String[] { "FirstName", "LastName", "Address", "PhoneNumber", "Email", });
    internal_static_seller_AddressModelSeller_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_seller_AddressModelSeller_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_seller_AddressModelSeller_descriptor,
        new java.lang.String[] { "City", "StreetName", "PostCode", });
    internal_static_seller_CreateUserModelRequestSeller_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_seller_CreateUserModelRequestSeller_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_seller_CreateUserModelRequestSeller_descriptor,
        new java.lang.String[] { "FirstName", "LastName", "Address", "PhoneNumber", "Email", "Password", });
    internal_static_seller_CreateSellerRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_seller_CreateSellerRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_seller_CreateSellerRequest_descriptor,
        new java.lang.String[] { "User", "Cvr", "CompanyName", "Description", "Type", "Website", "Rating", "Image", });
    internal_static_seller_SellerResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_seller_SellerResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_seller_SellerResponse_descriptor,
        new java.lang.String[] { "User", "Cvr", "CompanyName", "Description", "Type", "Website", "Rating", "Image", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
