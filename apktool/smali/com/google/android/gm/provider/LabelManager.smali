.class public Lcom/google/android/gm/provider/LabelManager;
.super Ljava/lang/Object;
.source "LabelManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gm/provider/LabelManager$LabelFactory;
    }
.end annotation


# static fields
.field private static final FORCED_INCLUDED_LABELS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final FORCED_INCLUDED_OR_PARTIAL_LABELS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final FORCED_NON_SYNCED_LABELS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final FORCED_SYNCED_NO_NOTIFY_LABELS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final LABEL_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

.field private static final SORTED_USER_MEANINGFUL_SYSTEM_LABELS:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static sAsyncLabelFetchHandler:Landroid/os/Handler;

.field private static final sCachedLabels:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/Label;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 11

    .prologue
    .line 32
    const-string v0, "^i"

    const-string v1, "^iim"

    const-string v2, "^t"

    const-string v3, "^io_im"

    const-string v4, "^b"

    const-string v5, "^f"

    const-string v6, "^^out"

    const-string v7, "^r"

    const-string v8, "^all"

    const-string v9, "^s"

    const-string v10, "^k"

    invoke-static/range {v0 .. v10}, Lcom/google/common/collect/ImmutableList;->of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/LabelManager;->SORTED_USER_MEANINGFUL_SYSTEM_LABELS:Ljava/util/List;

    .line 52
    const-string v0, "^^out"

    const-string v1, "^r"

    invoke-static {v0, v1}, Lcom/google/common/collect/ImmutableSet;->of(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/LabelManager;->FORCED_INCLUDED_LABELS:Ljava/util/Set;

    .line 59
    const-string v0, "^f"

    invoke-static {v0}, Lcom/google/common/collect/ImmutableSet;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/LabelManager;->FORCED_INCLUDED_OR_PARTIAL_LABELS:Ljava/util/Set;

    .line 69
    const-string v0, "^^out"

    const-string v1, "^r"

    const-string v2, "^f"

    invoke-static {v0, v1, v2}, Lcom/google/common/collect/ImmutableSet;->of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/LabelManager;->FORCED_SYNCED_NO_NOTIFY_LABELS:Ljava/util/Set;

    .line 81
    const-string v0, "^s"

    const-string v1, "^b"

    const-string v2, "^all"

    const-string v3, "^k"

    invoke-static {v0, v1, v2, v3}, Lcom/google/common/collect/ImmutableSet;->of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/LabelManager;->FORCED_NON_SYNCED_LABELS:Ljava/util/Set;

    .line 111
    const-string v0, "\\^\\*\\*\\^"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/LabelManager;->LABEL_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    .line 390
    const/4 v0, 0x0

    sput-object v0, Lcom/google/android/gm/provider/LabelManager;->sAsyncLabelFetchHandler:Landroid/os/Handler;

    .line 403
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v0, Lcom/google/android/gm/provider/LabelManager;->sCachedLabels:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 417
    return-void
.end method

.method public static getForcedIncludedLabels()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 56
    sget-object v0, Lcom/google/android/gm/provider/LabelManager;->FORCED_INCLUDED_LABELS:Ljava/util/Set;

    return-object v0
.end method

.method public static getForcedIncludedOrPartialLabels()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 63
    sget-object v0, Lcom/google/android/gm/provider/LabelManager;->FORCED_INCLUDED_OR_PARTIAL_LABELS:Ljava/util/Set;

    return-object v0
.end method

.method public static getForcedSyncedNoNotifyLabels()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 73
    sget-object v0, Lcom/google/android/gm/provider/LabelManager;->FORCED_SYNCED_NO_NOTIFY_LABELS:Ljava/util/Set;

    return-object v0
.end method

.method public static getFreshLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gm/provider/Label;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "canonicalName"    # Ljava/lang/String;

    .prologue
    .line 266
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lcom/google/android/gm/provider/LabelManager;->getLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Lcom/google/android/gm/provider/Label;

    move-result-object v0

    return-object v0
.end method

.method public static getLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gm/provider/Label;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "canonicalName"    # Ljava/lang/String;

    .prologue
    .line 281
    const/4 v0, 0x1

    invoke-static {p0, p1, p2, v0}, Lcom/google/android/gm/provider/LabelManager;->getLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Lcom/google/android/gm/provider/Label;

    move-result-object v0

    return-object v0
.end method

.method public static getLabel(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Lcom/google/android/gm/provider/Label;
    .locals 10
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "canonicalName"    # Ljava/lang/String;
    .param p3, "useCache"    # Z

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 295
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 297
    .local v0, "accountLabelKey":Ljava/lang/String;
    const/4 v1, 0x0

    .line 298
    .local v1, "label":Lcom/google/android/gm/provider/Label;
    if-eqz p3, :cond_0

    .line 299
    sget-object v5, Lcom/google/android/gm/provider/LabelManager;->sCachedLabels:Ljava/util/Map;

    invoke-interface {v5, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "label":Lcom/google/android/gm/provider/Label;
    check-cast v1, Lcom/google/android/gm/provider/Label;

    .line 300
    .restart local v1    # "label":Lcom/google/android/gm/provider/Label;
    if-eqz v1, :cond_0

    move-object v2, v1

    .line 318
    .end local v1    # "label":Lcom/google/android/gm/provider/Label;
    .local v2, "label":Lcom/google/android/gm/provider/Label;
    :goto_0
    return-object v2

    .line 305
    .end local v2    # "label":Lcom/google/android/gm/provider/Label;
    .restart local v1    # "label":Lcom/google/android/gm/provider/Label;
    :cond_0
    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail;->getLabelsUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 306
    .local v3, "labelQueryUri":Landroid/net/Uri;
    invoke-static {p2}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v3, v5}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 308
    const-string v5, "1"

    invoke-static {v3, v5}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 310
    new-instance v4, Lcom/google/android/gm/provider/LabelList;

    invoke-direct {v4, p0, p1, v3, v9}, Lcom/google/android/gm/provider/LabelList;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/net/Uri;Z)V

    .line 312
    .local v4, "labels":Lcom/google/android/gm/provider/LabelList;
    invoke-virtual {v4}, Lcom/google/android/gm/provider/LabelList;->size()I

    move-result v5

    if-lez v5, :cond_1

    .line 313
    invoke-virtual {v4, v8}, Lcom/google/android/gm/provider/LabelList;->get(I)Lcom/google/android/gm/provider/Label;

    move-result-object v1

    .line 314
    sget-object v5, Lcom/google/android/gm/provider/LabelManager;->sCachedLabels:Ljava/util/Map;

    invoke-interface {v5, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :goto_1
    move-object v2, v1

    .line 318
    .end local v1    # "label":Lcom/google/android/gm/provider/Label;
    .restart local v2    # "label":Lcom/google/android/gm/provider/Label;
    goto :goto_0

    .line 316
    .end local v2    # "label":Lcom/google/android/gm/provider/Label;
    .restart local v1    # "label":Lcom/google/android/gm/provider/Label;
    :cond_1
    const-string v5, "Gmail.LabelManager"

    const-string v6, "Unable to get label %s for account %s"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    aput-object p2, v7, v8

    aput-object p1, v7, v9

    invoke-static {v5, v6, v7}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_1
.end method

.method public static getLabelList(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Z)Lcom/google/android/gm/provider/LabelList;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Ljava/lang/String;
    .param p3, "hiddenLabels"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;Z)",
            "Lcom/google/android/gm/provider/LabelList;"
        }
    .end annotation

    .prologue
    .line 209
    .local p2, "canonicalNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail;->getLabelsUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v2

    .line 210
    .local v2, "uriBuilder":Landroid/net/Uri$Builder;
    if-eqz p3, :cond_0

    const-string v3, "1"

    :goto_0
    invoke-virtual {v2, v3}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v2

    .line 214
    if-eqz p2, :cond_1

    .line 215
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v1

    .line 216
    .local v1, "numLabels":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    if-ge v0, v1, :cond_1

    .line 217
    const-string v4, "canonicalName"

    invoke-interface {p2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v2, v4, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 216
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 210
    .end local v0    # "i":I
    .end local v1    # "numLabels":I
    :cond_0
    const-string v3, "0"

    goto :goto_0

    .line 221
    :cond_1
    new-instance v3, Lcom/google/android/gm/provider/LabelList;

    invoke-virtual {v2}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v4

    invoke-direct {v3, p0, p1, v4, p3}, Lcom/google/android/gm/provider/LabelList;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/net/Uri;Z)V

    return-object v3
.end method

.method public static getRecentLabelList(Landroid/content/Context;Ljava/lang/String;JI)Lcom/google/android/gm/provider/LabelList;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "before"    # J
    .param p4, "limit"    # I

    .prologue
    .line 233
    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail;->getLabelsUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "0"

    invoke-virtual {v1, v2}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "before"

    invoke-static {p2, p3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string v2, "limit"

    int-to-long v3, p4

    invoke-static {v3, v4}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    .line 239
    .local v0, "uri":Landroid/net/Uri;
    new-instance v1, Lcom/google/android/gm/provider/LabelList;

    const/4 v2, 0x0

    invoke-direct {v1, p0, p1, v0, v2}, Lcom/google/android/gm/provider/LabelList;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/net/Uri;Z)V

    return-object v1
.end method

.method public static getSortedUserMeaningfulSystemLabels()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 44
    sget-object v0, Lcom/google/android/gm/provider/LabelManager;->SORTED_USER_MEANINGFUL_SYSTEM_LABELS:Ljava/util/List;

    return-object v0
.end method

.method public static parseLabelQueryResult(Landroid/content/Context;Ljava/lang/String;)Ljava/util/Map;
    .locals 10
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "labelQueryResult"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/Label;",
            ">;"
        }
    .end annotation

    .prologue
    .line 136
    const-string v6, "Gmail.LabelManager"

    const-string v7, "label query result: %s"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object p1, v8, v9

    invoke-static {v6, v7, v8}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 138
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v3

    .line 139
    .local v3, "labels":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/android/gm/provider/Label;>;"
    if-eqz p1, :cond_1

    .line 141
    invoke-static {p0}, Lcom/google/android/gm/provider/Label;->getSystemLabelNameMap(Landroid/content/Context;)Ljava/util/Map;

    move-result-object v5

    .line 144
    .local v5, "systemLabelNameMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/CharSequence;>;"
    sget-object v6, Lcom/google/android/gm/provider/LabelManager;->LABEL_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    invoke-static {p1, v6}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;

    move-result-object v2

    .line 145
    .local v2, "labelStrings":[Ljava/lang/String;
    array-length v4, v2

    .line 146
    .local v4, "numLabels":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v4, :cond_1

    .line 147
    aget-object v6, v2, v0

    invoke-static {v6, v5}, Lcom/google/android/gm/provider/Label;->parseJoinedString(Ljava/lang/String;Ljava/util/Map;)Lcom/google/android/gm/provider/Label;

    move-result-object v1

    .line 148
    .local v1, "label":Lcom/google/android/gm/provider/Label;
    if-eqz v1, :cond_0

    .line 149
    invoke-virtual {v1}, Lcom/google/android/gm/provider/Label;->getCanonicalName()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v3, v6, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 146
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 153
    .end local v0    # "i":I
    .end local v1    # "label":Lcom/google/android/gm/provider/Label;
    .end local v2    # "labelStrings":[Ljava/lang/String;
    .end local v4    # "numLabels":I
    .end local v5    # "systemLabelNameMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/CharSequence;>;"
    :cond_1
    return-object v3
.end method

.method public static parseLabelQueryResult(Ljava/lang/String;)Ljava/util/Map;
    .locals 1
    .param p0, "labelQueryResult"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/Label;",
            ">;"
        }
    .end annotation

    .prologue
    .line 122
    const/4 v0, 0x0

    check-cast v0, Landroid/content/Context;

    invoke-static {v0, p0}, Lcom/google/android/gm/provider/LabelManager;->parseLabelQueryResult(Landroid/content/Context;Ljava/lang/String;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public static parseLabelQueryResult(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    .locals 5
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "labelQueryResult"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/Label;",
            ">;"
        }
    .end annotation

    .prologue
    .line 158
    const-string v1, "Gmail.LabelManager"

    const-string v2, "label query result: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 160
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    .line 161
    .local v0, "labels":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/android/gm/provider/Label;>;"
    const/4 v1, 0x0

    invoke-static {p0, p1, v0, v1}, Lcom/google/android/gm/provider/LabelManager;->parseLabelQueryResult(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V

    .line 162
    return-object v0
.end method

.method public static parseLabelQueryResult(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V
    .locals 8
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "labelQueryResult"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/Label;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Lcom/google/android/gm/provider/Label;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 167
    .local p2, "result":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/android/gm/provider/Label;>;"
    .local p3, "cachedLabels":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Long;Lcom/google/android/gm/provider/Label;>;"
    const-string v4, "Gmail.LabelManager"

    const-string v5, "label query result: %s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    invoke-static {v4, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 169
    invoke-interface {p2}, Ljava/util/Map;->clear()V

    .line 170
    if-eqz p1, :cond_1

    .line 171
    sget-object v4, Lcom/google/android/gm/provider/LabelManager;->LABEL_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    invoke-static {p1, v4}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;

    move-result-object v2

    .line 172
    .local v2, "labelStrings":[Ljava/lang/String;
    array-length v3, v2

    .line 173
    .local v3, "numLabels":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v3, :cond_1

    .line 174
    aget-object v4, v2, v0

    const/4 v5, 0x0

    invoke-static {p0, v4, v5, p3}, Lcom/google/android/gm/provider/Label;->parseJoinedString(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)Lcom/google/android/gm/provider/Label;

    move-result-object v1

    .line 176
    .local v1, "label":Lcom/google/android/gm/provider/Label;
    if-eqz v1, :cond_0

    .line 177
    invoke-virtual {v1}, Lcom/google/android/gm/provider/Label;->getCanonicalName()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p2, v4, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 173
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 181
    .end local v0    # "i":I
    .end local v1    # "label":Lcom/google/android/gm/provider/Label;
    .end local v2    # "labelStrings":[Ljava/lang/String;
    .end local v3    # "numLabels":I
    :cond_1
    return-void
.end method

.method public static serialize(Ljava/util/Map;)Ljava/lang/String;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/Label;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 184
    .local p0, "labels":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/android/gm/provider/Label;>;"
    invoke-interface {p0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v2

    .line 185
    .local v2, "labelCollection":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/google/android/gm/provider/Label;>;"
    const/4 v6, 0x0

    new-array v6, v6, [Lcom/google/android/gm/provider/Label;

    invoke-interface {v2, v6}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Lcom/google/android/gm/provider/Label;

    .line 186
    .local v3, "labelList":[Lcom/google/android/gm/provider/Label;
    array-length v4, v3

    .line 187
    .local v4, "numLabels":I
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 188
    .local v5, "result":Ljava/lang/StringBuilder;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v4, :cond_1

    .line 189
    if-lez v0, :cond_0

    .line 190
    const-string v6, "^**^"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 192
    :cond_0
    aget-object v1, v3, v0

    .line 193
    .local v1, "label":Lcom/google/android/gm/provider/Label;
    invoke-virtual {v1}, Lcom/google/android/gm/provider/Label;->serialize()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 188
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 195
    .end local v1    # "label":Lcom/google/android/gm/provider/Label;
    :cond_1
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    return-object v6
.end method

.method public static updateRecentLabels(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, "labelTimestampMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Long;>;"
    const/4 v6, 0x0

    .line 244
    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail;->getLabelsUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v4}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v4

    const-string v5, "lastTouched"

    invoke-virtual {v4, v5}, Landroid/net/Uri$Builder;->appendEncodedPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v4

    invoke-virtual {v4}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v2

    .line 248
    .local v2, "uri":Landroid/net/Uri;
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 249
    .local v3, "values":Landroid/content/ContentValues;
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 250
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Long;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Long;

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    goto :goto_0

    .line 252
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Long;>;"
    :cond_0
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    invoke-virtual {v4, v2, v3, v6, v6}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 253
    return-void
.end method
