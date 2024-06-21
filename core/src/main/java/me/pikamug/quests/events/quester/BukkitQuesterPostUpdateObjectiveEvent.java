/*
 * Copyright (c) PikaMug and contributors
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package me.pikamug.quests.events.quester;

import me.pikamug.quests.player.BukkitQuester;
import me.pikamug.quests.quests.Quest;
import me.pikamug.quests.quests.components.Objective;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called after a quester progresses an objective
 */
public class BukkitQuesterPostUpdateObjectiveEvent extends BukkitQuesterEvent implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();
    private final Quest quest;
    private final Objective objective;
    private boolean cancel = false;
    
    public BukkitQuesterPostUpdateObjectiveEvent(final BukkitQuester quester, final Quest quest, final Objective objective) {
        super(quester);
        this.quest = quest;
        this.objective = objective;
    }
    
    /**
     * Returns the quest involved in this event
     * 
     * @return Quest which is involved in this event
     */
    public Quest getQuest() {
        return quest;
    }
    
    /**
     * Returns the objective involved in this event
     * 
     * @return Objective which is involved in this event
     */
    public Objective getObjective() {
        return objective;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(final boolean cancel) {
        this.cancel = cancel;
    }
    
    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }
     
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
