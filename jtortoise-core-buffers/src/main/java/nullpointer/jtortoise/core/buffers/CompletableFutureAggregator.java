package nullpointer.jtortoise.core.buffers;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

class CompletableFutureAggregator {
    public CompletableFuture<Void> aggregate(Collection<CompletableFuture<Void>> futures) {
        int futuresCount = futures.size();
        CompletableFuture[] futuresArray = new CompletableFuture[futuresCount];
        int i = 0;
        for (CompletableFuture<Void> future : futures) {
            futuresArray[i] = future;
            i += 1;
        }
        return CompletableFuture.allOf(futuresArray);
    }
}
