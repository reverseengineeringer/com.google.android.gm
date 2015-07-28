.class public final Lcom/google/android/gms/common/GooglePlayServicesUtil;
.super Ljava/lang/Object;
.source "GooglePlayServicesUtil.java"


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static final VALID_PUBLIC_SIGNATURES:[[B


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 43
    const-class v0, Lcom/google/android/gms/common/GooglePlayServicesUtil;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/google/android/gms/common/GooglePlayServicesUtil;->TAG:Ljava/lang/String;

    .line 77
    const/4 v0, 0x2

    new-array v0, v0, [[B

    const-string v1, "MIIEQzCCAyugAwIBAgIJAMLgh0ZkSjCNMA0GCSqGSIb3DQEBBAUAMHQxCzAJBgNVBAYTAlVTMRMwEQYDVQQIEwpDYWxpZm9ybmlhMRYwFAYDVQQHEw1Nb3VudGFpbiBWaWV3MRQwEgYDVQQKEwtHb29nbGUgSW5jLjEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDAeFw0wODA4MjEyMzEzMzRaFw0zNjAxMDcyMzEzMzRaMHQxCzAJBgNVBAYTAlVTMRMwEQYDVQQIEwpDYWxpZm9ybmlhMRYwFAYDVQQHEw1Nb3VudGFpbiBWaWV3MRQwEgYDVQQKEwtHb29nbGUgSW5jLjEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDCCASAwDQYJKoZIhvcNAQEBBQADggENADCCAQgCggEBAKtWLgDYO6IIrgqWbxJOKdoR8qtW0I9Y4sypEwPpt1TTcvZApxsdyxMJZ2JORland2qSGT2y5b+3JKkedxiLDmpHpDsz2WCbdxgxRczfey5YZnTJ4VZbH0xqWVW/8lGmPav5xVwnIiJS6HXk+BVKZF+JcWjAsb/GEuq/eFdpuzSqeYTcfi6idkyugwfYwXFU1+5fZKUaRKYCwkkFQVfcAs1fXA5V+++FGfvjJ/CxURaSxaBvGdGDhfXE28LWuT9ozCl5xw4Yq5OGazvV24mZVSoOO0yZ31j7kYvtwYK6NeADwbSxDdJEqO4k//0zOHKrUiGYXtqw/A0LFFtqoZKFjnkCAQOjgdkwgdYwHQYDVR0OBBYEFMd9jMIhF1Ylmn/Tgt9r45jk14alMIGmBgNVHSMEgZ4wgZuAFMd9jMIhF1Ylmn/Tgt9r45jk14aloXikdjB0MQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEUMBIGA1UEChMLR29vZ2xlIEluYy4xEDAOBgNVBAsTB0FuZHJvaWQxEDAOBgNVBAMTB0FuZHJvaWSCCQDC4IdGZEowjTAMBgNVHRMEBTADAQH/MA0GCSqGSIb3DQEBBAUAA4IBAQBt0lLO74UwLDYKqs6Tm8/yzKkEu116FmH4rkaymUIE0P9KaMftGlMexFlaYjzmB2OxZyl6euNXEsQH8gjwyxCUKRJNexBiGcCEyj6z+a1fuHHvkiaai+KL8W1EyNmgjmyy8AW7P+LLlkR+ho5zEHatRbM/YAnqGcFh5iZBqpknHf1SKMXFh4dd239FJ1jWYfbMDMy3NS5CTMQ2XFI1MvcyUTdZPErjQfTbQe3aDQsQcafEQPD+nqActifKZ0Np0IS9L9kR/wbNvyz6ENwPiTrjV2KRkEjH78ZMcUQXg0L3BYHJ3lc69Vs5Ddf9uUGGMYldX3WfMBEmh/9iFBDAaTCK"

    invoke-static {v1, v3}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v1

    aput-object v1, v0, v3

    const/4 v1, 0x1

    const-string v2, "MIIEqDCCA5CgAwIBAgIJANWFuGx90071MA0GCSqGSIb3DQEBBAUAMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbTAeFw0wODA0MTUyMzM2NTZaFw0zNTA5MDEyMzM2NTZaMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbTCCASAwDQYJKoZIhvcNAQEBBQADggENADCCAQgCggEBANbOLggKv+IxTdGNs8/TGFy0PTP6DHThvbbR24kT9ixcOd9W+EaBPWW+wPPKQmsHxajtWjmQwWfna8mZuSeJS48LIgAZlKkpFeVyxW0qMBujb8X8ETrWy550NaFtI6t9+u7hZeTfHwqNvacKhp1RbE6dBRGWynwMVX8XW8N1+UjFaq6GCJukT4qmpN2afb8sCjUigq0GuMwYXrFVee74bQgLHWGJwPmvmLHC69EH6kWr22ijx4OKXlSIx2xT1AsSHee70w5iDBiK4aph27yH3TxkXy9V89TDdexAcKk/cVHYNnDBapcavl7y0RiQ4biu8ymM8Ga/nmzhRKya6G0cGw8CAQOjgfwwgfkwHQYDVR0OBBYEFI0cxb6VTEM8YYY6FbBMvAPyT+CyMIHJBgNVHSMEgcEwgb6AFI0cxb6VTEM8YYY6FbBMvAPyT+CyoYGapIGXMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbYIJANWFuGx90071MAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEEBQADggEBABnTDPEF+3iSP0wNfdIjIz1AlnrPzgAIHVvXxunW7SBrDhEglQZBbKJEk5kT0mtKoOD1JMrSu1xuTKEBahWRbqHsXclaXjoBADb0kkjVEJu/Lh5hgYZnOjvlba8Ld7HCKePCVePoTJBdI4fvugnL8TsgK05aIskyY0hKI9L8KfqfGTl1lzOv2KoWD0KWwtAWPoGChZxmQ+nBli+gwYMzM1vAkP+aayLe0a1EQimlOalO762r0GXO0ks+UeXde2Z4e+8S/pf7pITEI/tP+MxJTALw9QUWEv9lKTk+jkbqxbsh8nfBUapfKqYn0eidpwq2AzVp3juYl7//fKnaPhJD9gs="

    invoke-static {v2, v3}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v2

    aput-object v2, v0, v1

    sput-object v0, Lcom/google/android/gms/common/GooglePlayServicesUtil;->VALID_PUBLIC_SIGNATURES:[[B

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 126
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 128
    return-void
.end method

.method public static isGooglePlayServicesAvailable(Landroid/content/Context;)I
    .locals 11
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/16 v6, 0x9

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 140
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 143
    .local v2, "packageManager":Landroid/content/pm/PackageManager;
    const-string v9, "com.android.vending"

    const/16 v10, 0x40

    invoke-virtual {v2, v9, v10}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v5

    .line 147
    .local v5, "storePackageInfo":Landroid/content/pm/PackageInfo;
    sget-object v9, Lcom/google/android/gms/common/GooglePlayServicesUtil;->VALID_PUBLIC_SIGNATURES:[[B

    invoke-static {v5, v9}, Lcom/google/android/gms/common/GooglePlayServicesUtil;->verifySignature(Landroid/content/pm/PackageInfo;[[B)[B

    move-result-object v3

    .line 150
    .local v3, "playStoreSignature":[B
    if-nez v3, :cond_1

    .line 176
    .end local v2    # "packageManager":Landroid/content/pm/PackageManager;
    .end local v3    # "playStoreSignature":[B
    .end local v5    # "storePackageInfo":Landroid/content/pm/PackageInfo;
    :cond_0
    :goto_0
    return v6

    .line 155
    .restart local v2    # "packageManager":Landroid/content/pm/PackageManager;
    .restart local v3    # "playStoreSignature":[B
    .restart local v5    # "storePackageInfo":Landroid/content/pm/PackageInfo;
    :cond_1
    const-string v9, "com.google.android.gms"

    const/16 v10, 0x40

    invoke-virtual {v2, v9, v10}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v4

    .line 159
    .local v4, "servicePackageInfo":Landroid/content/pm/PackageInfo;
    const/4 v9, 0x1

    new-array v9, v9, [[B

    const/4 v10, 0x0

    aput-object v3, v9, v10

    invoke-static {v4, v9}, Lcom/google/android/gms/common/GooglePlayServicesUtil;->verifySignature(Landroid/content/pm/PackageInfo;[[B)[B

    move-result-object v9

    if-eqz v9, :cond_0

    .line 163
    iget v6, v4, Landroid/content/pm/PackageInfo;->versionCode:I

    const/16 v9, 0x3f7

    if-ge v6, v9, :cond_2

    .line 164
    const/4 v6, 0x2

    goto :goto_0

    .line 167
    :cond_2
    const-string v6, "com.google.android.gms"

    const/4 v9, 0x0

    invoke-virtual {v2, v6, v9}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    .line 169
    .local v0, "appInfo":Landroid/content/pm/ApplicationInfo;
    iget-boolean v6, v0, Landroid/content/pm/ApplicationInfo;->enabled:Z
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    if-nez v6, :cond_3

    .line 170
    const/4 v6, 0x3

    goto :goto_0

    :cond_3
    move v6, v7

    .line 173
    goto :goto_0

    .line 174
    .end local v0    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .end local v2    # "packageManager":Landroid/content/pm/PackageManager;
    .end local v3    # "playStoreSignature":[B
    .end local v4    # "servicePackageInfo":Landroid/content/pm/PackageInfo;
    .end local v5    # "storePackageInfo":Landroid/content/pm/PackageInfo;
    :catch_0
    move-exception v1

    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    move v6, v8

    .line 176
    goto :goto_0
.end method

.method private static varargs verifySignature(Landroid/content/pm/PackageInfo;[[B)[B
    .locals 11
    .param p0, "packageInfo"    # Landroid/content/pm/PackageInfo;
    .param p1, "allValidSignatures"    # [[B

    .prologue
    const/4 v7, 0x0

    .line 183
    :try_start_0
    const-string v8, "X509"

    invoke-static {v8}, Ljava/security/cert/CertificateFactory;->getInstance(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;

    move-result-object v1

    .line 185
    .local v1, "certificateFactory":Ljava/security/cert/CertificateFactory;
    iget-object v8, p0, Landroid/content/pm/PackageInfo;->signatures:[Landroid/content/pm/Signature;

    array-length v8, v8

    const/4 v9, 0x1

    if-eq v8, v9, :cond_1

    move-object v6, v7

    .line 210
    .end local v1    # "certificateFactory":Ljava/security/cert/CertificateFactory;
    :cond_0
    :goto_0
    return-object v6

    .line 189
    .restart local v1    # "certificateFactory":Ljava/security/cert/CertificateFactory;
    :cond_1
    new-instance v2, Ljava/io/ByteArrayInputStream;

    iget-object v8, p0, Landroid/content/pm/PackageInfo;->signatures:[Landroid/content/pm/Signature;

    const/4 v9, 0x0

    aget-object v8, v8, v9

    invoke-virtual {v8}, Landroid/content/pm/Signature;->toByteArray()[B

    move-result-object v8

    invoke-direct {v2, v8}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 192
    .local v2, "certificateStream":Ljava/io/InputStream;
    invoke-virtual {v1, v2}, Ljava/security/cert/CertificateFactory;->generateCertificate(Ljava/io/InputStream;)Ljava/security/cert/Certificate;

    move-result-object v0

    check-cast v0, Ljava/security/cert/X509Certificate;

    .line 195
    .local v0, "certificate":Ljava/security/cert/X509Certificate;
    invoke-virtual {v0}, Ljava/security/cert/X509Certificate;->checkValidity()V

    .line 196
    iget-object v8, p0, Landroid/content/pm/PackageInfo;->signatures:[Landroid/content/pm/Signature;

    const/4 v9, 0x0

    aget-object v8, v8, v9

    invoke-virtual {v8}, Landroid/content/pm/Signature;->toByteArray()[B

    move-result-object v5

    .line 197
    .local v5, "signature":[B
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_1
    array-length v8, p1

    if-ge v4, v8, :cond_2

    .line 198
    aget-object v6, p1, v4

    .line 199
    .local v6, "validSignature":[B
    invoke-static {v6, v5}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v8

    if-nez v8, :cond_0

    .line 197
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 204
    .end local v6    # "validSignature":[B
    :cond_2
    sget-object v8, Lcom/google/android/gms/common/GooglePlayServicesUtil;->TAG:Ljava/lang/String;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Signature not valid.  Found: \n"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const/4 v10, 0x0

    invoke-static {v5, v10}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/security/cert/CertificateException; {:try_start_0 .. :try_end_0} :catch_0

    move-object v6, v7

    .line 207
    goto :goto_0

    .line 208
    .end local v0    # "certificate":Ljava/security/cert/X509Certificate;
    .end local v1    # "certificateFactory":Ljava/security/cert/CertificateFactory;
    .end local v2    # "certificateStream":Ljava/io/InputStream;
    .end local v4    # "i":I
    .end local v5    # "signature":[B
    :catch_0
    move-exception v3

    .local v3, "e":Ljava/security/cert/CertificateException;
    move-object v6, v7

    .line 210
    goto :goto_0
.end method
