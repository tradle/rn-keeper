package io.tradle.react;

import com.facebook.crypto.keychain.KeyChain;

public class ConcealKeyChain implements KeyChain {
  private static final int AES_IV_SIZE = 16;

  private final byte[] encryptionKey;
  private final byte[] hmacKey;

  public ConcealKeyChain(final byte[] encryptionKey, final byte[] hmacKey) {
    this.encryptionKey = encryptionKey;
    this.hmacKey = hmacKey;
  }

  @Override
  public byte[] getCipherKey() {
    return encryptionKey;
  }

  @Override
  public byte[] getMacKey() {
    return hmacKey;
  }

  @Override
  public byte[] getNewIV() {
    return Crypto.randomBytes(AES_IV_SIZE);
  }

  @Override
  public void destroyKeys() {
  }
};