.class Lcom/google/android/gm/persistence/Persistence$AutoAdvanceAccountToGlobalMigrator;
.super Lcom/google/android/gm/persistence/Persistence$AccountToGlobalPreferenceMigrator;
.source "Persistence.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/persistence/Persistence;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "AutoAdvanceAccountToGlobalMigrator"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gm/persistence/Persistence$AccountToGlobalPreferenceMigrator",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gm/persistence/Persistence;


# direct methods
.method constructor <init>(Lcom/google/android/gm/persistence/Persistence;)V
    .locals 1

    .prologue
    .line 995
    iput-object p1, p0, Lcom/google/android/gm/persistence/Persistence$AutoAdvanceAccountToGlobalMigrator;->this$0:Lcom/google/android/gm/persistence/Persistence;

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/google/android/gm/persistence/Persistence$AccountToGlobalPreferenceMigrator;-><init>(Lcom/google/android/gm/persistence/Persistence;Lcom/google/android/gm/persistence/Persistence$1;)V

    return-void
.end method

.method private autoAdvanceSettingPriority(Ljava/lang/String;)I
    .locals 1
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 1037
    const-string v0, "newer"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1038
    const/4 v0, 0x3

    .line 1044
    :goto_0
    return v0

    .line 1039
    :cond_0
    const-string v0, "older"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1040
    const/4 v0, 0x2

    goto :goto_0

    .line 1041
    :cond_1
    const-string v0, "list"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1042
    const/4 v0, 0x1

    goto :goto_0

    .line 1044
    :cond_2
    const/4 v0, -0x1

    goto :goto_0
.end method


# virtual methods
.method public bridge synthetic migrateFromMultipleAccounts(Landroid/content/Context;Ljava/util/List;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Landroid/content/Context;
    .param p2, "x1"    # Ljava/util/List;

    .prologue
    .line 995
    invoke-virtual {p0, p1, p2}, Lcom/google/android/gm/persistence/Persistence$AutoAdvanceAccountToGlobalMigrator;->migrateFromMultipleAccounts(Landroid/content/Context;Ljava/util/List;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public migrateFromMultipleAccounts(Landroid/content/Context;Ljava/util/List;)Ljava/lang/String;
    .locals 9
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 1014
    .local p2, "accounts":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v5, 0x0

    .line 1017
    .local v5, "result":Ljava/lang/String;
    const/4 v2, -0x1

    .line 1018
    .local v2, "bestPriority":I
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 1019
    .local v0, "account":Ljava/lang/String;
    iget-object v6, p0, Lcom/google/android/gm/persistence/Persistence$AutoAdvanceAccountToGlobalMigrator;->this$0:Lcom/google/android/gm/persistence/Persistence;

    const-string v7, "auto-advance"

    const/4 v8, 0x0

    # invokes: Lcom/google/android/gm/persistence/Persistence;->getString(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    invoke-static {v6, p1, v0, v7, v8}, Lcom/google/android/gm/persistence/Persistence;->access$200(Lcom/google/android/gm/persistence/Persistence;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1021
    .local v1, "accountSetting":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 1022
    invoke-direct {p0, v1}, Lcom/google/android/gm/persistence/Persistence$AutoAdvanceAccountToGlobalMigrator;->autoAdvanceSettingPriority(Ljava/lang/String;)I

    move-result v4

    .line 1023
    .local v4, "priority":I
    if-le v4, v2, :cond_0

    .line 1024
    move v2, v4

    .line 1025
    move-object v5, v1

    goto :goto_0

    .line 1029
    .end local v0    # "account":Ljava/lang/String;
    .end local v1    # "accountSetting":Ljava/lang/String;
    .end local v4    # "priority":I
    :cond_1
    return-object v5
.end method

.method public bridge synthetic migrateFromSingleAccount(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Landroid/content/Context;
    .param p2, "x1"    # Ljava/lang/String;

    .prologue
    .line 995
    invoke-virtual {p0, p1, p2}, Lcom/google/android/gm/persistence/Persistence$AutoAdvanceAccountToGlobalMigrator;->migrateFromSingleAccount(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public migrateFromSingleAccount(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "account"    # Ljava/lang/String;

    .prologue
    .line 1009
    iget-object v0, p0, Lcom/google/android/gm/persistence/Persistence$AutoAdvanceAccountToGlobalMigrator;->this$0:Lcom/google/android/gm/persistence/Persistence;

    const-string v1, "auto-advance"

    const/4 v2, 0x0

    # invokes: Lcom/google/android/gm/persistence/Persistence;->getString(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    invoke-static {v0, p1, p2, v1, v2}, Lcom/google/android/gm/persistence/Persistence;->access$200(Lcom/google/android/gm/persistence/Persistence;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
