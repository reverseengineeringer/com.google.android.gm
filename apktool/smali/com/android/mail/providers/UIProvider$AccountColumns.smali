.class public final Lcom/android/mail/providers/UIProvider$AccountColumns;
.super Ljava/lang/Object;
.source "UIProvider.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/providers/UIProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "AccountColumns"
.end annotation


# static fields
.field public static HELP_INTENT_URI:Ljava/lang/String;

.field public static REAUTHENTICATION_INTENT_URI:Ljava/lang/String;

.field public static SEND_FEEDBACK_INTENT_URI:Ljava/lang/String;

.field public static SETTINGS_INTENT_URI:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 417
    const-string v0, "accountSettingsIntentUri"

    sput-object v0, Lcom/android/mail/providers/UIProvider$AccountColumns;->SETTINGS_INTENT_URI:Ljava/lang/String;

    .line 425
    const-string v0, "helpIntentUri"

    sput-object v0, Lcom/android/mail/providers/UIProvider$AccountColumns;->HELP_INTENT_URI:Ljava/lang/String;

    .line 433
    const-string v0, "sendFeedbackIntentUri"

    sput-object v0, Lcom/android/mail/providers/UIProvider$AccountColumns;->SEND_FEEDBACK_INTENT_URI:Ljava/lang/String;

    .line 441
    const-string v0, "reauthenticationUri"

    sput-object v0, Lcom/android/mail/providers/UIProvider$AccountColumns;->REAUTHENTICATION_INTENT_URI:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 322
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 486
    return-void
.end method
