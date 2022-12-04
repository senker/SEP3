// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CustomerProto.proto

package via.sep3.persistencetier.protobuf;

/**
 * Protobuf type {@code customer.CreateCustomerRequest}
 */
public final class CreateCustomerRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:customer.CreateCustomerRequest)
    CreateCustomerRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CreateCustomerRequest.newBuilder() to construct.
  private CreateCustomerRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CreateCustomerRequest() {
    preference_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CreateCustomerRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CreateCustomerRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomer.Builder subBuilder = null;
            if (user_ != null) {
              subBuilder = user_.toBuilder();
            }
            user_ = input.readMessage(via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomer.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(user_);
              user_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              preference_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            preference_.add(s);
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        preference_ = preference_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return via.sep3.persistencetier.protobuf.CustomerProto.internal_static_customer_CreateCustomerRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return via.sep3.persistencetier.protobuf.CustomerProto.internal_static_customer_CreateCustomerRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            via.sep3.persistencetier.protobuf.CreateCustomerRequest.class, via.sep3.persistencetier.protobuf.CreateCustomerRequest.Builder.class);
  }

  public static final int USER_FIELD_NUMBER = 1;
  private via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomer user_;
  /**
   * <code>.customer.CreateUserModelRequestCustomer user = 1;</code>
   * @return Whether the user field is set.
   */
  @java.lang.Override
  public boolean hasUser() {
    return user_ != null;
  }
  /**
   * <code>.customer.CreateUserModelRequestCustomer user = 1;</code>
   * @return The user.
   */
  @java.lang.Override
  public via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomer getUser() {
    return user_ == null ? via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomer.getDefaultInstance() : user_;
  }
  /**
   * <code>.customer.CreateUserModelRequestCustomer user = 1;</code>
   */
  @java.lang.Override
  public via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomerOrBuilder getUserOrBuilder() {
    return getUser();
  }

  public static final int PREFERENCE_FIELD_NUMBER = 2;
  private com.google.protobuf.LazyStringList preference_;
  /**
   * <code>repeated string preference = 2;</code>
   * @return A list containing the preference.
   */
  public com.google.protobuf.ProtocolStringList
      getPreferenceList() {
    return preference_;
  }
  /**
   * <code>repeated string preference = 2;</code>
   * @return The count of preference.
   */
  public int getPreferenceCount() {
    return preference_.size();
  }
  /**
   * <code>repeated string preference = 2;</code>
   * @param index The index of the element to return.
   * @return The preference at the given index.
   */
  public java.lang.String getPreference(int index) {
    return preference_.get(index);
  }
  /**
   * <code>repeated string preference = 2;</code>
   * @param index The index of the value to return.
   * @return The bytes of the preference at the given index.
   */
  public com.google.protobuf.ByteString
      getPreferenceBytes(int index) {
    return preference_.getByteString(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (user_ != null) {
      output.writeMessage(1, getUser());
    }
    for (int i = 0; i < preference_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, preference_.getRaw(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (user_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getUser());
    }
    {
      int dataSize = 0;
      for (int i = 0; i < preference_.size(); i++) {
        dataSize += computeStringSizeNoTag(preference_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getPreferenceList().size();
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof via.sep3.persistencetier.protobuf.CreateCustomerRequest)) {
      return super.equals(obj);
    }
    via.sep3.persistencetier.protobuf.CreateCustomerRequest other = (via.sep3.persistencetier.protobuf.CreateCustomerRequest) obj;

    if (hasUser() != other.hasUser()) return false;
    if (hasUser()) {
      if (!getUser()
          .equals(other.getUser())) return false;
    }
    if (!getPreferenceList()
        .equals(other.getPreferenceList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasUser()) {
      hash = (37 * hash) + USER_FIELD_NUMBER;
      hash = (53 * hash) + getUser().hashCode();
    }
    if (getPreferenceCount() > 0) {
      hash = (37 * hash) + PREFERENCE_FIELD_NUMBER;
      hash = (53 * hash) + getPreferenceList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static via.sep3.persistencetier.protobuf.CreateCustomerRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static via.sep3.persistencetier.protobuf.CreateCustomerRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static via.sep3.persistencetier.protobuf.CreateCustomerRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static via.sep3.persistencetier.protobuf.CreateCustomerRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static via.sep3.persistencetier.protobuf.CreateCustomerRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static via.sep3.persistencetier.protobuf.CreateCustomerRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static via.sep3.persistencetier.protobuf.CreateCustomerRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static via.sep3.persistencetier.protobuf.CreateCustomerRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static via.sep3.persistencetier.protobuf.CreateCustomerRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static via.sep3.persistencetier.protobuf.CreateCustomerRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static via.sep3.persistencetier.protobuf.CreateCustomerRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static via.sep3.persistencetier.protobuf.CreateCustomerRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(via.sep3.persistencetier.protobuf.CreateCustomerRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code customer.CreateCustomerRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:customer.CreateCustomerRequest)
      via.sep3.persistencetier.protobuf.CreateCustomerRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return via.sep3.persistencetier.protobuf.CustomerProto.internal_static_customer_CreateCustomerRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return via.sep3.persistencetier.protobuf.CustomerProto.internal_static_customer_CreateCustomerRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              via.sep3.persistencetier.protobuf.CreateCustomerRequest.class, via.sep3.persistencetier.protobuf.CreateCustomerRequest.Builder.class);
    }

    // Construct using via.sep3.persistencetier.protobuf.CreateCustomerRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (userBuilder_ == null) {
        user_ = null;
      } else {
        user_ = null;
        userBuilder_ = null;
      }
      preference_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return via.sep3.persistencetier.protobuf.CustomerProto.internal_static_customer_CreateCustomerRequest_descriptor;
    }

    @java.lang.Override
    public via.sep3.persistencetier.protobuf.CreateCustomerRequest getDefaultInstanceForType() {
      return via.sep3.persistencetier.protobuf.CreateCustomerRequest.getDefaultInstance();
    }

    @java.lang.Override
    public via.sep3.persistencetier.protobuf.CreateCustomerRequest build() {
      via.sep3.persistencetier.protobuf.CreateCustomerRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public via.sep3.persistencetier.protobuf.CreateCustomerRequest buildPartial() {
      via.sep3.persistencetier.protobuf.CreateCustomerRequest result = new via.sep3.persistencetier.protobuf.CreateCustomerRequest(this);
      int from_bitField0_ = bitField0_;
      if (userBuilder_ == null) {
        result.user_ = user_;
      } else {
        result.user_ = userBuilder_.build();
      }
      if (((bitField0_ & 0x00000001) != 0)) {
        preference_ = preference_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.preference_ = preference_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof via.sep3.persistencetier.protobuf.CreateCustomerRequest) {
        return mergeFrom((via.sep3.persistencetier.protobuf.CreateCustomerRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(via.sep3.persistencetier.protobuf.CreateCustomerRequest other) {
      if (other == via.sep3.persistencetier.protobuf.CreateCustomerRequest.getDefaultInstance()) return this;
      if (other.hasUser()) {
        mergeUser(other.getUser());
      }
      if (!other.preference_.isEmpty()) {
        if (preference_.isEmpty()) {
          preference_ = other.preference_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensurePreferenceIsMutable();
          preference_.addAll(other.preference_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      via.sep3.persistencetier.protobuf.CreateCustomerRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (via.sep3.persistencetier.protobuf.CreateCustomerRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomer user_;
    private com.google.protobuf.SingleFieldBuilderV3<
        via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomer, via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomer.Builder, via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomerOrBuilder> userBuilder_;
    /**
     * <code>.customer.CreateUserModelRequestCustomer user = 1;</code>
     * @return Whether the user field is set.
     */
    public boolean hasUser() {
      return userBuilder_ != null || user_ != null;
    }
    /**
     * <code>.customer.CreateUserModelRequestCustomer user = 1;</code>
     * @return The user.
     */
    public via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomer getUser() {
      if (userBuilder_ == null) {
        return user_ == null ? via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomer.getDefaultInstance() : user_;
      } else {
        return userBuilder_.getMessage();
      }
    }
    /**
     * <code>.customer.CreateUserModelRequestCustomer user = 1;</code>
     */
    public Builder setUser(via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomer value) {
      if (userBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        user_ = value;
        onChanged();
      } else {
        userBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.customer.CreateUserModelRequestCustomer user = 1;</code>
     */
    public Builder setUser(
        via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomer.Builder builderForValue) {
      if (userBuilder_ == null) {
        user_ = builderForValue.build();
        onChanged();
      } else {
        userBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.customer.CreateUserModelRequestCustomer user = 1;</code>
     */
    public Builder mergeUser(via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomer value) {
      if (userBuilder_ == null) {
        if (user_ != null) {
          user_ =
            via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomer.newBuilder(user_).mergeFrom(value).buildPartial();
        } else {
          user_ = value;
        }
        onChanged();
      } else {
        userBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.customer.CreateUserModelRequestCustomer user = 1;</code>
     */
    public Builder clearUser() {
      if (userBuilder_ == null) {
        user_ = null;
        onChanged();
      } else {
        user_ = null;
        userBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.customer.CreateUserModelRequestCustomer user = 1;</code>
     */
    public via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomer.Builder getUserBuilder() {
      
      onChanged();
      return getUserFieldBuilder().getBuilder();
    }
    /**
     * <code>.customer.CreateUserModelRequestCustomer user = 1;</code>
     */
    public via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomerOrBuilder getUserOrBuilder() {
      if (userBuilder_ != null) {
        return userBuilder_.getMessageOrBuilder();
      } else {
        return user_ == null ?
            via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomer.getDefaultInstance() : user_;
      }
    }
    /**
     * <code>.customer.CreateUserModelRequestCustomer user = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomer, via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomer.Builder, via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomerOrBuilder> 
        getUserFieldBuilder() {
      if (userBuilder_ == null) {
        userBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomer, via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomer.Builder, via.sep3.persistencetier.protobuf.CreateUserModelRequestCustomerOrBuilder>(
                getUser(),
                getParentForChildren(),
                isClean());
        user_ = null;
      }
      return userBuilder_;
    }

    private com.google.protobuf.LazyStringList preference_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensurePreferenceIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        preference_ = new com.google.protobuf.LazyStringArrayList(preference_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string preference = 2;</code>
     * @return A list containing the preference.
     */
    public com.google.protobuf.ProtocolStringList
        getPreferenceList() {
      return preference_.getUnmodifiableView();
    }
    /**
     * <code>repeated string preference = 2;</code>
     * @return The count of preference.
     */
    public int getPreferenceCount() {
      return preference_.size();
    }
    /**
     * <code>repeated string preference = 2;</code>
     * @param index The index of the element to return.
     * @return The preference at the given index.
     */
    public java.lang.String getPreference(int index) {
      return preference_.get(index);
    }
    /**
     * <code>repeated string preference = 2;</code>
     * @param index The index of the value to return.
     * @return The bytes of the preference at the given index.
     */
    public com.google.protobuf.ByteString
        getPreferenceBytes(int index) {
      return preference_.getByteString(index);
    }
    /**
     * <code>repeated string preference = 2;</code>
     * @param index The index to set the value at.
     * @param value The preference to set.
     * @return This builder for chaining.
     */
    public Builder setPreference(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensurePreferenceIsMutable();
      preference_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string preference = 2;</code>
     * @param value The preference to add.
     * @return This builder for chaining.
     */
    public Builder addPreference(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensurePreferenceIsMutable();
      preference_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string preference = 2;</code>
     * @param values The preference to add.
     * @return This builder for chaining.
     */
    public Builder addAllPreference(
        java.lang.Iterable<java.lang.String> values) {
      ensurePreferenceIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, preference_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string preference = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPreference() {
      preference_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string preference = 2;</code>
     * @param value The bytes of the preference to add.
     * @return This builder for chaining.
     */
    public Builder addPreferenceBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensurePreferenceIsMutable();
      preference_.add(value);
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:customer.CreateCustomerRequest)
  }

  // @@protoc_insertion_point(class_scope:customer.CreateCustomerRequest)
  private static final via.sep3.persistencetier.protobuf.CreateCustomerRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new via.sep3.persistencetier.protobuf.CreateCustomerRequest();
  }

  public static via.sep3.persistencetier.protobuf.CreateCustomerRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CreateCustomerRequest>
      PARSER = new com.google.protobuf.AbstractParser<CreateCustomerRequest>() {
    @java.lang.Override
    public CreateCustomerRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new CreateCustomerRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CreateCustomerRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CreateCustomerRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public via.sep3.persistencetier.protobuf.CreateCustomerRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

