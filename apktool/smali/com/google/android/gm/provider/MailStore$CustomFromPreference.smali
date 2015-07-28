.class public Lcom/google/android/gm/provider/MailStore$CustomFromPreference;
.super Ljava/lang/Object;
.source "MailStore.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/MailStore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CustomFromPreference"
.end annotation


# instance fields
.field public address:Ljava/lang/String;

.field public isDefault:Ljava/lang/String;

.field public name:Ljava/lang/String;

.field public replyTo:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "address"    # Ljava/lang/String;
    .param p3, "isDefault"    # Ljava/lang/String;
    .param p4, "replyTo"    # Ljava/lang/String;

    .prologue
    .line 155
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 156
    iput-object p1, p0, Lcom/google/android/gm/provider/MailStore$CustomFromPreference;->name:Ljava/lang/String;

    .line 157
    iput-object p2, p0, Lcom/google/android/gm/provider/MailStore$CustomFromPreference;->address:Ljava/lang/String;

    .line 158
    iput-object p4, p0, Lcom/google/android/gm/provider/MailStore$CustomFromPreference;->replyTo:Ljava/lang/String;

    .line 159
    iput-object p3, p0, Lcom/google/android/gm/provider/MailStore$CustomFromPreference;->isDefault:Ljava/lang/String;

    .line 160
    return-void
.end method
