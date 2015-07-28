.class public Lcom/google/android/gm/GmailApplication;
.super Landroid/app/Application;
.source "GmailApplication.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    .line 24
    return-void
.end method


# virtual methods
.method public onCreate()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 33
    const-string v0, "Gmail"

    const v1, 0x7f070001

    invoke-static {p0, v0, v2, v1, v2}, Landroid/preference/PreferenceManager;->setDefaultValues(Landroid/content/Context;Ljava/lang/String;IIZ)V

    .line 35
    const-string v0, "Gmail"

    const v1, 0x7f070003

    invoke-static {p0, v0, v2, v1, v2}, Landroid/preference/PreferenceManager;->setDefaultValues(Landroid/content/Context;Ljava/lang/String;IIZ)V

    .line 37
    const-string v0, "Gmail"

    const/high16 v1, 0x7f070000

    invoke-static {p0, v0, v2, v1, v2}, Landroid/preference/PreferenceManager;->setDefaultValues(Landroid/content/Context;Ljava/lang/String;IIZ)V

    .line 39
    return-void
.end method

.method public onTerminate()V
    .locals 0

    .prologue
    .line 43
    return-void
.end method
