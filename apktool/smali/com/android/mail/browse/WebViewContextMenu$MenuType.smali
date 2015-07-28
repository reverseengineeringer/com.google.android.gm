.class public final enum Lcom/android/mail/browse/WebViewContextMenu$MenuType;
.super Ljava/lang/Enum;
.source "WebViewContextMenu.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/browse/WebViewContextMenu;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401c
    name = "MenuType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/android/mail/browse/WebViewContextMenu$MenuType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/android/mail/browse/WebViewContextMenu$MenuType;

.field public static final enum ADD_CONTACT_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

.field public static final enum COPY_GEO_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

.field public static final enum COPY_LINK_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

.field public static final enum COPY_MAIL_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

.field public static final enum COPY_PHONE_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

.field public static final enum DIAL_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

.field public static final enum EMAIL_CONTACT_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

.field public static final enum MAP_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

.field public static final enum OPEN_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

.field public static final enum SHARE_LINK_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

.field public static final enum SMS_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 61
    new-instance v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    const-string v1, "OPEN_MENU"

    invoke-direct {v0, v1, v3}, Lcom/android/mail/browse/WebViewContextMenu$MenuType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->OPEN_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    .line 62
    new-instance v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    const-string v1, "COPY_LINK_MENU"

    invoke-direct {v0, v1, v4}, Lcom/android/mail/browse/WebViewContextMenu$MenuType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->COPY_LINK_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    .line 63
    new-instance v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    const-string v1, "SHARE_LINK_MENU"

    invoke-direct {v0, v1, v5}, Lcom/android/mail/browse/WebViewContextMenu$MenuType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->SHARE_LINK_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    .line 64
    new-instance v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    const-string v1, "DIAL_MENU"

    invoke-direct {v0, v1, v6}, Lcom/android/mail/browse/WebViewContextMenu$MenuType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->DIAL_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    .line 65
    new-instance v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    const-string v1, "SMS_MENU"

    invoke-direct {v0, v1, v7}, Lcom/android/mail/browse/WebViewContextMenu$MenuType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->SMS_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    .line 66
    new-instance v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    const-string v1, "ADD_CONTACT_MENU"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/android/mail/browse/WebViewContextMenu$MenuType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->ADD_CONTACT_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    .line 67
    new-instance v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    const-string v1, "COPY_PHONE_MENU"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/android/mail/browse/WebViewContextMenu$MenuType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->COPY_PHONE_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    .line 68
    new-instance v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    const-string v1, "EMAIL_CONTACT_MENU"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/android/mail/browse/WebViewContextMenu$MenuType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->EMAIL_CONTACT_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    .line 69
    new-instance v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    const-string v1, "COPY_MAIL_MENU"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/android/mail/browse/WebViewContextMenu$MenuType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->COPY_MAIL_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    .line 70
    new-instance v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    const-string v1, "MAP_MENU"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/android/mail/browse/WebViewContextMenu$MenuType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->MAP_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    .line 71
    new-instance v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    const-string v1, "COPY_GEO_MENU"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/android/mail/browse/WebViewContextMenu$MenuType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->COPY_GEO_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    .line 60
    const/16 v0, 0xb

    new-array v0, v0, [Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    sget-object v1, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->OPEN_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->COPY_LINK_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->SHARE_LINK_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->DIAL_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->SMS_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->ADD_CONTACT_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->COPY_PHONE_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->EMAIL_CONTACT_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->COPY_MAIL_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->MAP_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->COPY_GEO_MENU:Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->$VALUES:[Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 60
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/android/mail/browse/WebViewContextMenu$MenuType;
    .locals 1

    .prologue
    .line 60
    const-class v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    return-object v0
.end method

.method public static values()[Lcom/android/mail/browse/WebViewContextMenu$MenuType;
    .locals 1

    .prologue
    .line 60
    sget-object v0, Lcom/android/mail/browse/WebViewContextMenu$MenuType;->$VALUES:[Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    invoke-virtual {v0}, [Lcom/android/mail/browse/WebViewContextMenu$MenuType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/android/mail/browse/WebViewContextMenu$MenuType;

    return-object v0
.end method
