# 🎒 Expendable Backpacks

A feature-rich backpack plugin for Paper/Spigot 1.21.1+ with 8 unique tiers, upgrades, and special Enderpack functionality!

[![Version](https://img.shields.io/badge/version-1.0.0-blue.svg)](https://github.com/shweit/expendable-backpacks)
[![Minecraft](https://img.shields.io/badge/minecraft-1.21.1-green.svg)](https://www.minecraft.net/)
[![License](https://img.shields.io/badge/license-MIT-yellow.svg)](LICENSE)

---

## ✨ Features

- 🎒 **8 Unique Backpack Tiers** - From Dirt to Netherite, each with increasing storage
- 📦 **Automatic Inventory Saving** - Your items are safe, even after server restarts
- 🔄 **Upgradeable Backpacks** - Craft upgrades to expand your storage without losing items
- 🌌 **Special Enderpack** - Shared storage across multiple Enderpacks with the same ID
- 🧬 **Enderpack Cloning** - Create multiple access points to the same storage
- 🛡️ **Inception Protection** - Can't put backpacks inside other backpacks
- 🎨 **Custom Textures** - Beautiful player head textures for each tier
- 📖 **Interactive GUI Guide** - In-game guide showing all recipes and features
- 💾 **Persistent Storage** - All backpacks saved to YAML with unique UUIDs
- ⚡ **Performance Optimized** - Efficient inventory caching and saving

---

## 📊 Backpack Tiers

| Tier | Rows | Slots | Material | Color |
|------|------|-------|----------|-------|
| **Dirt Backpack** | 1 | 9 | Dirt | Gray |
| **Leather Backpack** | 1 | 9 | Leather | Gray |
| **Copper Backpack** | 2 | 18 | Copper Ingot | Orange |
| **Iron Backpack** | 3 | 27 | Iron Ingot | White |
| **Gold Backpack** | 4 | 36 | Gold Ingot | Yellow |
| **Diamond Backpack** | 5 | 45 | Diamond | Cyan |
| **Netherite Backpack** | 6 | 54 | Netherite Ingot | Dark Gray |
| **Enderpack** | 3 | 27 | Ender Pearl | Purple |

---

## 🔨 Crafting Recipes

### Leather Backpack (Starting Tier)
```
L S L
L C L
L L L
```
- **L** = Leather
- **S** = String
- **C** = Chest

### Dirt Backpack (Downgrade)
```
D D D
D B D
D D D
```
- **D** = Dirt
- **B** = Leather Backpack

### Enderpack (Special Crafting)
```
E P E
P C P
E I E
```
- **E** = Ender Eye
- **P** = Ender Pearl
- **C** = Chest
- **I** = Iron Block

### Enderpack Cloning
```
1 Enderpack + 1 Ender Pearl = 2 Enderpacks (same ID!)
```
Both Enderpacks share the same inventory - perfect for multiple access points!

### Upgrades
Surround your backpack with **8x upgrade material** in a crafting table:

- **Leather → Copper**: 8x Copper Ingot
- **Copper → Iron**: 8x Iron Ingot
- **Iron → Gold**: 8x Gold Ingot
- **Gold → Diamond**: 8x Diamond
- **Diamond → Netherite**: Smithing Table (Template + Diamond Backpack + Netherite Ingot)

**⚠️ Important:** Upgrades preserve your items and UUID!

---

## 🎮 Commands

| Command | Description | Permission |
|---------|-------------|------------|
| `/backpack` | Open interactive guide GUI | `backpack.use` |
| `/backpack help` | Show help guide | `backpack.use` |
| `/backpack give <player> <tier>` | Give a backpack to a player | `backpack.give` |
| `/backpack open <uuid>` | Open a backpack by UUID | `backpack.openOthers` |
| `/backpack clear <uuid>` | Clear a backpack's contents | `backpack.clear` |
| `/backpack clone <uuid>` | Get a clone of an Enderpack | `backpack.clone` |

---

## 🔑 Permissions

| Permission | Description | Default |
|------------|-------------|---------|
| `backpack.use` | Use backpack command and open own backpacks | Everyone |
| `backpack.give` | Give backpacks to players | OP |
| `backpack.openOthers` | Open backpacks by UUID | OP |
| `backpack.clear` | Clear backpack contents | OP |
| `backpack.clone` | Clone Enderpacks | OP |
| `backpack.admin` | All admin permissions (includes all above) | OP |

---

## 📥 Installation

1. **Download** the latest `ExpendableBackpacks-1.0.0.jar` from [Releases](https://github.com/shweit/expendable-backpacks/releases)
2. **Place** the JAR file in your server's `plugins/` folder
3. **Restart** your server
4. **Done!** Use `/backpack` to see the guide

### Requirements
- **Minecraft Version:** 1.21.1+
- **Server Software:** Paper or Spigot
- **Java Version:** 21+

---

## 🎯 Usage

### Opening Backpacks
Simply **right-click** any backpack in your inventory to open it!

### Viewing the Guide
Use `/backpack` to open an interactive GUI showing:
- All backpack tiers
- Crafting recipes with visual patterns
- Upgrade paths
- Special Enderpack features

### Creating Your First Backpack
1. Craft a **Leather Backpack** (Leather + String + Chest)
2. Right-click to open it
3. Store your items!
4. Upgrade it by surrounding it with materials

---

## 🌌 Enderpack Special Features

The **Enderpack** is unique:
- 🔗 **Shared Storage**: All Enderpacks with the same ID share the same inventory
- 🧬 **Clonable**: Craft 1 Enderpack + 1 Ender Pearl to get 2 Enderpacks with the same ID
- 🏠 **Multiple Access Points**: Keep one in your inventory, one in a chest at your base, give one to a friend!
- 💜 **Purple Themed**: Special lore and color coding

### Example Use Case
1. Craft an Enderpack
2. Clone it (Enderpack + Ender Pearl = 2 Enderpacks with same ID)
3. Keep one in your inventory, store one in a chest at your base, give one to a friend
4. Everyone with an Enderpack of the same ID accesses the same storage!

---

## 💾 Data Storage

Backpacks are stored in `plugins/ExpendableBackpacks/backpacks.yml`:
- Each backpack has a unique UUID
- Inventories are saved automatically
- Data persists through server restarts
- Tab completion shows all saved backpack UUIDs

---

## 🛠️ Configuration

Currently, the plugin works out-of-the-box with no configuration needed!

Future updates may include:
- Customizable tier slots
- Custom crafting recipes
- Configurable textures
- Permissions per tier

---

## 🐛 Bug Reports & Suggestions

Found a bug or have a suggestion? Please open an issue on our [GitHub Issues](https://github.com/shweit/expendable-backpacks/issues) page!

---

## 📝 Changelog

### Version 1.0.0 - Initial Release
- ✨ First public release
- 🎒 8 backpack tiers (Dirt to Netherite + Enderpack)
- 🌌 Enderpack with shared storage functionality
- 🧬 Enderpack cloning system (1:1 ratio)
- 🔄 Full upgrade system with material surrounding
- 🛡️ Inception protection (title-based detection)
- 📖 Interactive GUI guide with visual recipes
- 💾 YAML-based persistent storage
- ⚡ Performance optimized inventory caching

---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🌟 Support

If you enjoy this plugin, please consider:
- ⭐ Starring this repository
- 📢 Sharing it with your friends
- 💬 Leaving a review on Modrinth/SpigotMC
- ☕ [Buying me a coffee](https://www.buymeacoffee.com/shweit)

---

Made with ❤️ for the Minecraft community
